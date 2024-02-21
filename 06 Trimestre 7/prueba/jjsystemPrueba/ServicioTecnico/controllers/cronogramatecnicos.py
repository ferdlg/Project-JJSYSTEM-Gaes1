from rest_framework import viewsets
from ..models import Cronogramatecnicos
from .serializers import CronogramatecnicosSerializer


class cronogramatecnicosCRUD(viewsets.ModelViewSet):
    queryset = Cronogramatecnicos.objects.all()
    serializer_class = CronogramatecnicosSerializer