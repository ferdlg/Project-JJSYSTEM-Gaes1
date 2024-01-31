from rest_framework import viewsets
from ..models import Permisos
from serializers import PermisosSerializers


class permisosCRUD(viewsets.ModelViewSet):
    queryset = Permisos.objects.all()
    serializer_class = PermisosSerializers