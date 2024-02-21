from rest_framework import viewsets
from ..models import Estadospqrsf
from .serializers import EstadosPqrsfSerializer

class estadospqrsfCRUD(viewsets.ModelViewSet):
    queryset = Estadospqrsf.objects.all()
    serializer_class = EstadosPqrsfSerializer