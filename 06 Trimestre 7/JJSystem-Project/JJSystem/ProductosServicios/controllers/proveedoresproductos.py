from rest_framework import viewsets
from ..models import Proveedoresproductos
from serializers import ProveedoresProductosSerializer


class proveedoresCRUD(viewsets.ModelViewSet):
    queryset = Proveedoresproductos.objects.all()
    serializer_class = ProveedoresProductosSerializer