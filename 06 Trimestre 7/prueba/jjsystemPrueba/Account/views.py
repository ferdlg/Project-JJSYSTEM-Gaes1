# En tus vistas (por ejemplo, myapp/views.py)
from django.shortcuts import render, HttpResponse
from .forms import loginForm, registerForm
from .models import Roles, Estadosusuarios
from django.http import HttpResponseForbidden
from django.shortcuts import redirect
from django.contrib.auth import authenticate, login , logout

def userLogin(request):
    if request.user.is_authenticated:
        # Si el usuario ya está autenticado, no vuelve al login
        if request.user.idrol.idrol == 1:
            return redirect('homeEnvios')
        elif request.user.idrol.idrol == 2:
            return HttpResponse('Vista cliente')
        elif request.user.idrol.idrol == 3:
            return redirect('homeTecnicosEnvios')
        else:
            return redirect('vista_por_defecto')

    if request.method == 'POST':
        form = loginForm(request.POST)
        if form.is_valid():
            email = form.cleaned_data['email']
            password = form.cleaned_data['password']
            user = authenticate(request, email=email, password=password)
            if user is not None:
                login(request, user)
                if user.idrol.idrol == 1:
                    return redirect('homeEnvios')
                elif user.idrol.idrol == 2:
                    return HttpResponse('Vista cliente')
                elif user.idrol.idrol == 3:
                    return redirect('homeTecnicosEnvios')
                else:
                    return redirect('vista_por_defecto')
            else:
                return HttpResponse('Credenciales incorrectas')
    else:
        form = loginForm()

    return render(request, 'Login.html', {'form': form})

def registerView(request):
    if request.method == 'POST':
        form = registerForm(request.POST)
        if form.is_valid():
            user = form.save(commit=False)
            user.idrol = Roles.objects.get(idrol=2)  # Asigna el rol de cliente
            user.idestadosusuarios = Estadosusuarios.objects.get(idestadousuario=1)  # Asigna el estado de usuario activo
            user.save()
            return redirect('login')
    else:
        form = registerForm()

    return render(request, 'register.html', {'form': form})


def role_required(required_idrol):
    def decorator(view_func):
        def _wrapped_view_func(request, *args, **kwargs):
            if request.user.idrol.idrol == required_idrol:
                return view_func(request, *args, **kwargs)
            else:
                return HttpResponseForbidden('No tienes permiso para acceder a esta página.')
        return _wrapped_view_func
    return decorator

def logoutView(request):
    logout(request)
    return redirect('login')
