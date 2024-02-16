from rest_framework import viewsets
from ..models import Cotizaciones
from .serializers import CotizacionesSerializer


class cotizacionesCRUD(viewsets.ModelViewSet):
    queryset = Cotizaciones.objects.all()
    serializer_class = CotizacionesSerializer