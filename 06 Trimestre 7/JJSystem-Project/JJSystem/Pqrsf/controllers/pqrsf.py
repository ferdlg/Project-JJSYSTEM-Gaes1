from rest_framework import viewsets
from ..models import *
from serializers import PqrsfSerializer

class pqrsfCRUD(viewsets.ModelViewSet):
    queryset = Pqrsf.objects.all()
    serializer_class = PqrsfSerializer