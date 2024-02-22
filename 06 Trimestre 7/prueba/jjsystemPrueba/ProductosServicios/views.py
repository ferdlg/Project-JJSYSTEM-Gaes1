from django.shortcuts import render

# Create your views here.
def landing(request):
    return render(request, 'landing/Index.html')

def servicios(request):
    return render(request, 'landing/Servicios.html')

def productos(request):
    return render(request, 'landing/Productos.html')
