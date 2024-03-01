from rest_framework import viewsets
from ..models import *
from .serializers import EstadosSerializers

class estadosCRUD(viewsets.ModelViewSet):
    queryset =  EstadoLibros.objects.all()
    serializer_class = EstadosSerializers
    