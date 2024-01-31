from rest_framework import viewsets
from ..models import Categoriasservicios
from serializers import CategoriasServiciosSerializers


class productosCRUD(viewsets.ModelViewSet):
    queryset = Categoriasservicios.objects.all()
    serializer_class = CategoriasServiciosSerializers