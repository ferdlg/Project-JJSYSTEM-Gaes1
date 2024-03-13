from django.shortcuts import redirect, render
from rest_framework import viewsets
from ..models import *
from .serializers import VentasSerializer
from django.core.paginator import Paginator , EmptyPage , PageNotAnInteger


class ventasCRUD(viewsets.ModelViewSet):
    queryset = Ventas.objects.all()
    serializer_class = VentasSerializer

# Ventas en dashboard admin
def home_ventas(request):
    ventas_list = Ventas.objects.all()

    paginator = Paginator(ventas_list, 5)
    page_number = request.GET.get('page')
    try:
        ventas = paginator.page(page_number)
    except PageNotAnInteger:
        ventas = paginator.page(1)
    except EmptyPage:
        ventas = paginator.page(paginator.num_pages)
    
    return render(request, "crudAdmin/IndexVentas.html", {"ventas":ventas})

def createVenta(request):
    if request.method == 'POST':
        fechaventa = request.POST.get('fechaventa')
        idenvio = request.POST.get('idenvio')
        idcotizacion = request.POST.get('idcotizacion')

        # Crear la instancia de venta
        venta = Ventas.objects.create(
            fechaventa=fechaventa,
            idenvio=idenvio,
            idcotizacion=idcotizacion
        )
        return redirect('homeVentas')

    envios = Envios.objects.all()
    cotizaciones = Cotizaciones.objects.all()
    return render(request, "crudAdmin/create_venta.html", {"envios": envios, "cotizaciones": cotizaciones})

def editVenta(request, idVenta):
    venta = Ventas.objects.get(idventa=idVenta)
    if request.method == 'POST':
        fechaventa = request.POST.get('fechaventa')
        idenvio = request.POST.get('idenvio')
        idcotizacion = request.POST.get('idcotizacion')

        # Actualizar los campos de la venta
        venta.fechaventa = fechaventa
        venta.idenvio = idenvio
        venta.idcotizacion = idcotizacion
        venta.save()

        return redirect('homeVentas')

    envios = Envios.objects.all()
    cotizaciones = Cotizaciones.objects.all()
    return render(request, "crudAdmin/edit_venta.html", {"venta": venta, "envios": envios, "cotizaciones": cotizaciones})

def deleteVenta(request, idVenta):
    venta = Ventas.objects.get(idventa=idVenta)
    venta.delete()
    return redirect('homeVentas')