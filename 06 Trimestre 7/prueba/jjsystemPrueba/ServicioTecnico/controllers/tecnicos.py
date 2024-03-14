from rest_framework.response import Response
from rest_framework import viewsets, status
from django.shortcuts import render, redirect
from django.contrib.auth.hashers import make_password, check_password
from Account.forms import RegisterForm
from Account.models import Estadosusuarios, Roles, Tecnicos
from .serializers import TecnicosSerializer
from django.core.paginator import Paginator , EmptyPage , PageNotAnInteger


class tecnicosCRUD(viewsets.ModelViewSet):
    queryset = Tecnicos.objects.all()
    serializer_class = TecnicosSerializer

    @classmethod
    def listar_tecnicos(cls, request):
        tecnicos_list = cls.queryset

        paginator = Paginator(tecnicos_list, 5)  # Mostrar 10 productos por página
        page_number = request.GET.get('page')      # Obtener el número de página solicitado
        try:
            tecnico = paginator.page(page_number)
        except PageNotAnInteger:
            tecnico = paginator.page(1)
        except EmptyPage:
            tecnico = paginator.page(paginator.num_pages)
        return render(request, 'vertecnicos.html', {'tecnicos': tecnico})
    
    @classmethod
    def registrar_tecnico(cls, request):
        if request.method == 'POST':
            form = RegisterForm(request.POST)
        if form.is_valid():
            user = form.save(commit=False)
            # Cifrar la contraseña antes de guardarla
            user.password = make_password(form.cleaned_data['numerodocumento'])
            user.idrol = Roles.objects.get(idrol=3)  # Asigna el rol de tecnico
            user.idestadosusuarios = Estadosusuarios.objects.get(idestadousuario=1)  # Asigna el estado de usuario activo
            user.save()
            return redirect('login')
        else:
            form = RegisterForm()

        return render(request, 'register.html', {'form': form})

    #Mostrar listado de tecnicos
    #registrar tecnicos
    #actualizar datos de tecnicos
    #eliminar tecnicos
    #que la contraseña inicialmente sea el numero de documento 