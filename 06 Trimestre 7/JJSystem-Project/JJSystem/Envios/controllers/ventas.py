from rest_framework import viewsets
from ..models import *
from serializers import VentasSerializers

class enviosCRUD (viewsets.ModelViewSet):
    queryset = Ventas.objects.all()
    serializer_class = VentasSerializers