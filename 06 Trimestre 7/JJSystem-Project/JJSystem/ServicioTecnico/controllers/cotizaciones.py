from rest_framework import viewsets
from ..models import Cotizaciones
from serializers import CotizacionesSerializers


class clientesCRUD(viewsets.ModelViewSet):
    queryset = Cotizaciones.objects.all()
    serializer_class = CotizacionesSerializers