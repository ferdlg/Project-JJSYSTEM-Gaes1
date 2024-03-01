from rest_framework import viewsets
from ..models import Usuarios
from .serializers import UsuariosSerializers
from rest_framework import status
from rest_framework.response import Response
from django.contrib.auth.hashers import make_password

class usuariosCRUD(viewsets.ModelViewSet):
    queryset = Usuarios.objects.all()
    serializer_class = UsuariosSerializers

    def create(self, request, *args, **kwargs):
            # Obtener los datos de la solicitud
            data = request.data.copy()

            # Extraer la contraseña de los datos de la solicitud
            password = data.pop('password', None)
            
            # Crear una nueva instancia de serializer con los datos de la solicitud
            serializer = self.get_serializer(data=data)
            serializer.is_valid(raise_exception=True)

            # Si se proporcionó una contraseña, cifrarla antes de guardarla
            if password:
                data['password'] = make_password(str(password))

            # Guardar el objeto y responder con los datos serializados
            self.perform_create(serializer)
            return Response(serializer.data, status=status.HTTP_201_CREATED)