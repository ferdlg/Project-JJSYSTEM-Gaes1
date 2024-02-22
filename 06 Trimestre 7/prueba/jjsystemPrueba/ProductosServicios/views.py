from django.shortcuts import render
from .models import Productos
# Create your views here.
def landing(request):
    return render(request, 'landing/Index.html')

def servicios(request):
    return render(request, 'landing/Servicios.html')

def productos(request):
    return render(request, 'landing/Productos.html')

def home(request):
    productos = Productos.objects.all()
    return render(request, "crudAdmin/IndexProductos.html", {"productos": productos})
