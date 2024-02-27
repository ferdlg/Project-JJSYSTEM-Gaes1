from rest_framework import viewsets
from ..models import *
from .serializers import CategoriasSerializers

class categoriasCRUD(viewsets.ModelViewSet):
    queryset =  CategoriaLibros.objects.all()
    serializer_class = CategoriasSerializers
