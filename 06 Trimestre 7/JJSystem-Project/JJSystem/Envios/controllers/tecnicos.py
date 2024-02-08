from rest_framework import viewsets
from ..models import *
from .serializers import TecnicosSerializers

class enviosCRUD (viewsets.ModelViewSet):
    queryset = Tecnicos.objects.all()
    serializer_class = TecnicosSerializers