from rest_framework import viewsets
from ..models import Estadospqrsf
from .serializers import EstadospqrsfSerializer

class pqrsfCRUD(viewsets.ModelViewSet):
    queryset = Estadospqrsf.objects.all()
    serializer_class = EstadospqrsfSerializer