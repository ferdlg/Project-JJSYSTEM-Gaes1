from rest_framework import viewsets
from ..models import Citas
from .serializers import CitasSerializers


class clientesCRUD(viewsets.ModelViewSet):
    queryset = Citas.objects.all()
    serializer_class = CitasSerializers