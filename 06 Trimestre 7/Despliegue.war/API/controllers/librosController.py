from rest_framework import viewsets
from ..models import *
from .serializers import LibrosSerializers

class librosCRUD(viewsets.ModelViewSet):
    queryset =  Libros.objects.all()
    serializer_class = LibrosSerializers
    