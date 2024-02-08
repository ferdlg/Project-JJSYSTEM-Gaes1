from rest_framework import viewsets
from ..models import *
from serializers import EnviosSerializers

class enviosCRUD (viewsets.ModelViewSet):
    queryset = Envios.objects.all()
    serializer_class = EnviosSerializers