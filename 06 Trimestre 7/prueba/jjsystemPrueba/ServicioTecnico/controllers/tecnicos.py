from rest_framework import viewsets
from ..models import Tecnicos
from .serializers import TecnicosSerializer


class tecnicosCRUD(viewsets.ModelViewSet):
    queryset = Tecnicos.objects.all()
    serializer_class = TecnicosSerializer