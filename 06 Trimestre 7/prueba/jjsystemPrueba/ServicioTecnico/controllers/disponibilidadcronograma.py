from rest_framework import viewsets
from ..models import Disponibilidadcronogramas
from .serializers import DisponibilidadcronogramasSerializer


class disponibilidadcronogramaCRUD(viewsets.ModelViewSet):
    queryset = Disponibilidadcronogramas.objects.all()
    serializer_class = DisponibilidadcronogramasSerializer

    #