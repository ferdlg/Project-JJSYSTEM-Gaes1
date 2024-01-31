from rest_framework import viewsets
from ..models import Roles
from serializers import RolesSerializers


class productosCRUD(viewsets.ModelViewSet):
    queryset = Roles.objects.all()
    serializer_class = RolesSerializers