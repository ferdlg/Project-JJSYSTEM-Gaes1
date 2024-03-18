import base64
from django.urls import reverse
from django.utils.encoding import force_bytes
from django.shortcuts import render, HttpResponse
from .forms import LoginForm, RegisterForm
from .models import Roles, Estadosusuarios, Usuarios, Clientes
from django.http import HttpResponseForbidden
from django.shortcuts import redirect
from django.contrib.auth import login , logout 
from django.contrib.auth.tokens import default_token_generator
from django.contrib.auth.forms import PasswordResetForm
from django.core.mail import send_mail
from django.contrib.auth.hashers import make_password, check_password
from django.contrib import messages


def registerView(request):
    if request.method == 'POST':
        form = RegisterForm(request.POST)
        if form.is_valid():
            user = form.save(commit=False)
            # Cifrar la contraseña antes de guardarla
            user.password = make_password(form.cleaned_data['password'])
            user.idrol = Roles.objects.get(idrol=2)  # Asigna el rol de cliente
            user.idestadosusuarios = Estadosusuarios.objects.get(idestadousuario=1)  # Asigna el estado de usuario activo
            user.save()
            return redirect('login')
    else:
        form = RegisterForm()

    return render(request, 'register.html', {'form': form})

def userLogin(request):
    if request.user.is_authenticated:
        # Si el usuario ya está autenticado, redirige según su rol
        if request.user.idrol.idrol == 1:
            return redirect('homeEnvios')
        elif request.user.idrol.idrol == 2:
            return redirect('productos')
        elif request.user.idrol.idrol == 3:
            return redirect('homeTecnicosEnvios')
        else:
            return redirect('vista_por_defecto')

    if request.method == 'POST':
        form = LoginForm(request.POST)
        if form.is_valid():
            email = form.cleaned_data['email']
            password = form.cleaned_data['password']
            # Buscar el usuario por email en la base de datos
            try:
                user = Usuarios.objects.get(email=email)
            except Usuarios.DoesNotExist:
                user = None

            # Si se encontró el usuario y la contraseña coincide, iniciar sesión
            if user is not None and check_password(password, user.password):
                login(request, user)
                # Redirigir según el rol del usuario
                if user.idrol.idrol == 1:
                    return redirect('homeEnvios')
                elif user.idrol.idrol == 2:
                    # Redireccionar al cliente a una vista especial
                    return redirect('productos')
                elif user.idrol.idrol == 3:
                    return redirect('homeTecnicosEnvios')
                else:
                    return redirect('vista_por_defecto')
            else:
                # Si las credenciales son incorrectas, mostrar un mensaje de error
                return HttpResponse('Credenciales incorrectas')
    else:
        form = LoginForm()

    return render(request, 'Login.html', {'form': form})



#decorador de vistas
def role_required(required_idrol):
    def decorator(view_func):
        def _wrapped_view_func(request, *args, **kwargs):
            if request.user.idrol.idrol == required_idrol:
                return view_func(request, *args, **kwargs)
            else:
                return HttpResponseForbidden('No tienes permiso para acceder a esta página.')
        return _wrapped_view_func
    return decorator

#cierre de sesion
def logoutView(request):
    logout(request)
    return redirect('login')

#Restablecer contraseña
def password_reset_form(request):
    if request.method == "POST":
        form = PasswordResetForm(request.POST)
        if form.is_valid():
            email = form.cleaned_data['email']
            usuario = Usuarios.objects.filter(email=email).first()
            if usuario:
                uidb64 = base64.urlsafe_b64encode(force_bytes(usuario.numerodocumento))
                token = default_token_generator.make_token(usuario)
                url = reverse('password_reset_confirm', kwargs={'uidb64': uidb64, 'token': token})
                reset_enlace = request.build_absolute_uri(url)
                send_mail(
                    'Solicitud de restablecimiento de contraseña',
                    f'Por favor, sigue este enlace para restablecer tu contraseña: {reset_enlace}',
                    'jjsystemproject@gmail.com',
                    [email],
                    fail_silently=False,
                )
                return redirect('password_reset_done')
            else:
                messages.error(request, 'No se encontró ningún usuario con este correo electrónico.')
        else:
            messages.error(request, 'Ingresa un correo electrónico válido')
    else:
        form = PasswordResetForm()
    return render(request, 'password_reset_form.html', {'form': form})

def password_reset_confirm(request, uidb64, token):
    try:
        
        uid = base64.urlsafe_b64decode(uidb64).decode(usuario.numerod)
        usuario = Usuarios.objects.get(numerodocumento = uid)
    except (TypeError, ValueError, OverflowError,base64.binascii.Error, Usuarios.DoesNotExist):
        usuario = None
    
    if usuario is not None and default_token_generator.check_token(usuario, token):
        return render(request,'password_reset_confirm.html', {'uidb64':uidb64, 'token':token})
    else:
        messages.error(request, 'El enlace de restablecimiento de contraseña no es válido o ha caducado.')
        return redirect('password_reset_form')