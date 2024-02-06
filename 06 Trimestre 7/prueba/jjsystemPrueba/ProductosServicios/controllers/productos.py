from rest_framework import viewsets
from ..models import *
from .serializers import ProductosSerializer

'''
    Importamos la biblioteca viewsets 
    de Django Rest Framework la cual nos proporciona las
    operaciones de un crud 
'''

#definimos la clase 
class productosCRUD(viewsets.ModelViewSet):
    # usamos queryset, que traera todos los objetos de la clase
    queryset = Productos.objects.all()
    # usamos serializer class para poder ver los objetos que se traen 
    serializer_class = ProductosSerializer