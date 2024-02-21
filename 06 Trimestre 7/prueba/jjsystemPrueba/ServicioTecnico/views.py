from django.shortcuts import render

def index (request):
    return render(request, 'index.html')

def citaAnalisis(request):
    return render(request, 'citaAnalisis.html')

def citaInstalacion(request):
    return render(request, 'citaInstalacion.html')

def citaMantenimiento(request):
    return render(request, 'citaMantenimiento.html')