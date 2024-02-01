from rest_framework import viewsets
from ..models import Tecnicos
from serializers import TecnicosSerializers


class clientesCRUD(viewsets.ModelViewSet):
    queryset = Tecnicos.objects.all()
    serializer_class = TecnicosSerializers