from rest_framework import viewsets
from ..models import Clientes
from serializers import ClientesSerializers


class productosCRUD(viewsets.ModelViewSet):
    queryset = Clientes.objects.all()
    serializer_class = ClientesSerializers