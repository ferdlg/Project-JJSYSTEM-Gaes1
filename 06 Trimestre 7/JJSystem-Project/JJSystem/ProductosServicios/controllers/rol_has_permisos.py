from rest_framework import viewsets
from ..models import RolesHasPermisos
from serializers import Rol_has_permisosSerializers


class productosCRUD(viewsets.ModelViewSet):
    queryset = RolesHasPermisos.objects.all()
    serializer_class = Rol_has_permisosSerializers