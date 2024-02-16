from rest_framework import viewsets
from ..models import Detallesactividadcronograma
from .serializers import DetallesactividadcronogramaSerializer


class detallesactividadesCRUD(viewsets.ModelViewSet):
    queryset = Detallesactividadcronograma.objects.all()
    serializer_class = DetallesactividadcronogramaSerializer