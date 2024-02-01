from rest_framework import viewsets
from ..models import Categoriasproductos
from serializers import CategoriasProductosSerializers

#definimos la clase 
class categoriaproductosCRUD(viewsets.ModelViewSet):
    # usamos queryset, que traera todos los objetos de la clase
    queryset = Categoriasproductos.objects.all()
    # usamos serializer class para poder ver los objetos que se traen 
    serializer_class = CategoriasProductosSerializers