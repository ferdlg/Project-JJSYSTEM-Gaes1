from rest_framework import viewsets
from ..models import Tipospqrsf
from .serializers import TiposPqrsfSerializer

class tipospqrsfCRUD(viewsets.ModelViewSet):
    queryset = Tipospqrsf.objects.all()
    serializer_class = TiposPqrsfSerializer