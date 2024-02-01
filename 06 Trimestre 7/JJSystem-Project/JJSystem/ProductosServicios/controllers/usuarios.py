from rest_framework import viewsets
from ..models import Usuarios
from serializers import UsuariosSerializers


class usuariosCRUD(viewsets.ModelViewSet):
    queryset = Usuarios.objects.all()
    serializer_class = UsuariosSerializers