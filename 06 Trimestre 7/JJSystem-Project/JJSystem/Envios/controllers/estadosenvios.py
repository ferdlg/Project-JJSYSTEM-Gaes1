from rest_framework import viewsets
from ..models import *
from .serializers import EstadosEnviosSerializers

class enviosCRUD (viewsets.ModelViewSet):
    queryset = Estadosenvios.objects.all()
    serializer_class = EstadosEnviosSerializers