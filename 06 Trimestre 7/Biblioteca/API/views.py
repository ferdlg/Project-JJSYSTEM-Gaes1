from rest_framework import status
from rest_framework.response import Response
from rest_framework.decorators import api_view
from django.contrib.auth import get_user_model, authenticate, login
from .controllers.serializers import UsuariosSerializers

User = get_user_model()

@api_view(['POST'])
def registro(request):
    serializer = UsuariosSerializers(data = request.data)
    if serializer.is_valid():
        user = serializer.save()
        return Response(serializer.data, status=status.HTTP_201_CREATED)
    return Response(serializer.errors, status=status.HTTP_400_BAD_REQUEST)

@api_view(['POST'])
def login (request):
    username = request.data.get('username')
    password = request.data.get('password')
    user = authenticate(username=username, password = password)
    if user is not None:
        login(request, user)
        return Response({'message':'Inicio de sesion exitoso'})
    else:
        return Response({'message': 'Credenciales invalidas'})