from rest_framework import viewsets
from ..models import Tipospqrsf
from .serializers import TipospqrsfSerializer

class tipospqrsfCRUD(viewsets.ModelViewSet):
    queryset = Tipospqrsf.objects.all()
    serializer_class = TipospqrsfSerializer