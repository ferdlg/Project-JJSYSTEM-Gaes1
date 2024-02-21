from django.shortcuts import render
from .models import Envios

# Create your views here.

def home(request):
    envios = Envios.objects.all()
    return render(request, "Index.html", {"envios": envios})