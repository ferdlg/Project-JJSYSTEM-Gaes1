from rest_framework import viewsets
from ..models import Permisos
from serializers import PermisosSerializers


class productosCRUD(viewsets.ModelViewSet):
    queryset = Permisos.objects.all()
    serializer_class = PermisosSerializers