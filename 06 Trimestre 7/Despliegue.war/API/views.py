from rest_framework import status
from rest_framework.response import Response
from rest_framework.decorators import api_view
from django.contrib.auth import get_user_model, authenticate, login as auth_login
from .controllers.serializers import UsuariosSerializers
from django.contrib.auth.hashers import make_password

User = get_user_model()

@api_view(['POST'])
def registro(request):
    serializer = UsuariosSerializers(data=request.data)
    if serializer.is_valid():
        # Obtener la contraseña del request y cifrarla
        password = request.data.get('password')
        hashed_password = make_password(password)

        # Actualizar la contraseña en los datos del request
        request.data['password'] = hashed_password

        # Guardar el usuario con la contraseña cifrada
        serializer = UsuariosSerializers(data=request.data)
        if serializer.is_valid():
            user = serializer.save()
            return Response(serializer.data, status=status.HTTP_201_CREATED)
    return Response(serializer.errors, status=status.HTTP_400_BAD_REQUEST)

@api_view(['POST'])
def login(request):
    username = request.data.get('username')
    password = request.data.get('password')
    user = authenticate(username=username, password=password)
    if user is not None:
        auth_login(request, user)
        return Response({'message': 'Inicio de sesion exitoso'})
    else:
        return Response({'message': 'Credenciales invalidas'})
