from django.shortcuts import render
from rest_framework import viewsets
from .models import Citas
from .controllers.serializers import CitasSerializer
from .controllers.citas import citasCRUD

def index (request):
    return render(request, 'index.html')
