from rest_framework import viewsets
from ..models import Detallesactividadcronograma
from .serializers import DetallesactividadcronogramaSerializers


class clientesCRUD(viewsets.ModelViewSet):
    queryset = Detallesactividadcronograma.objects.all()
    serializer_class = DetallesactividadcronogramaSerializers