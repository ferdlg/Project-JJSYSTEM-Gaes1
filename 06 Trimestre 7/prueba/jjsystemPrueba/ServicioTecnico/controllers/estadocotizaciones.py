from rest_framework import viewsets
from ..models import Estadoscotizaciones
from .serializers import EstadoscotizacionesSerializers


class clientesCRUD(viewsets.ModelViewSet):
    queryset = Estadoscotizaciones.objects.all()
    serializer_class = EstadoscotizacionesSerializers