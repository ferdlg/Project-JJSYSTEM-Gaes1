from rest_framework import viewsets
from ..models import Estadospqrsf
from .serializers import EstadospqrsfSerializer

class estadospqrsfCRUD(viewsets.ModelViewSet):
    queryset = Estadospqrsf.objects.all()
    serializer_class = EstadospqrsfSerializer