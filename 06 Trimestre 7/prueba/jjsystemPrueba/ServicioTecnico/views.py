from django.shortcuts import render
from rest_framework import viewsets
from .models import Citas
from .controllers.serializers import CitasSerializer
from .controllers.citas import citasCRUD

def index (request):
    return render(request, 'index.html')


def citaAnalisis(request):
    citas = Citas.objects.all()
    return render(request, 'citaAnalisis.html', {'citas':citas})

def citaInstalacion(request):
    return render(request, 'citaInstalacion.html')

def citaMantenimiento(request):
    return render(request, 'citaMantenimiento.html')