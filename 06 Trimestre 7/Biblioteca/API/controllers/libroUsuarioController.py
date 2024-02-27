from rest_framework import viewsets
from ..models import *
from .serializers import LibroUsuarioSerializers

class libroUsuarioCRUD(viewsets.ModelViewSet):
    queryset =  LibroUsuario.objects.all()
    serializer_class = LibroUsuarioSerializers
    