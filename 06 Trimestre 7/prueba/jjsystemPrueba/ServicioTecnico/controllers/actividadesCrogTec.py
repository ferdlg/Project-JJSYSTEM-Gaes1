from rest_framework import viewsets
from ..models import Actividadescronogramatecnicos
from .serializers import ActividadescronogramatecnicosSerializer


class clientesCRUD(viewsets.ModelViewSet):
    queryset = Actividadescronogramatecnicos.objects.all()
    serializer_class = ActividadescronogramatecnicosSerializer