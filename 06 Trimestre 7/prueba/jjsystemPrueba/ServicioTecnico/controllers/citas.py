from django.shortcuts import render
from rest_framework import viewsets
from ..models import Citas
from .serializers import CitasSerializer

class citasCRUD(viewsets.ModelViewSet):
    queryset = Citas.objects.all()
    serializer_class = CitasSerializer

    #Metodo para obtener solo las citas de analisis
    def cita_analisis(self, request):
        #Obtener datos de la cita
        citas_queryset = Citas.objects.filter()
        citas_serializer = CitasSerializer(citas_queryset, many = True)
        citas_data = citas_serializer.data
        print(citas_data)
        return render(request, 'citaAnalisis.html', {'citas': citas_data})