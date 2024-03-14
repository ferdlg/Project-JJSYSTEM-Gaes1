from rest_framework import viewsets
from Account.models import Clientes
from .serializers import ClientesSerializers


class clientesCRUD(viewsets.ModelViewSet):
    queryset = Clientes.objects.all()
    serializer_class = ClientesSerializers