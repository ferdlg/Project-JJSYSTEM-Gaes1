from rest_framework import viewsets
from django.shortcuts import render, redirect
from django.core.paginator import Paginator, EmptyPage, PageNotAnInteger
from Account.models import Cotizaciones, Clientes, Estadoscotizaciones, Productos, Servicios, CotizacionesProductos, CotizacionesServicios
from .serializers import CotizacionesSerializer
from django.contrib import messages

class CotizacionesCRUD(viewsets.ModelViewSet):
    queryset = Cotizaciones.objects.all()
    serializer_class = CotizacionesSerializer

    def listar_cotizaciones(self, request):
        cotizaciones_list = self.get_queryset()
        paginator = Paginator(cotizaciones_list, 5)
        page_number = request.GET.get('page', 1)
        try:
            cotizaciones = paginator.page(page_number)
        except PageNotAnInteger:
            cotizaciones = paginator.page(1)
        except EmptyPage:
            cotizaciones = paginator.page(paginator.num_pages)
        
        estados = Estadoscotizaciones.objects.all()
        clientes = Clientes.objects.all()
        return render(request, 'cotizaciones.html', {'cotizaciones': cotizaciones, 'estados':estados, 'clientes':clientes})

    def crear_cotizaciones(self, request):
        if request.method == 'POST':
            totalcotizacion = request.POST.get('totalCotizacion')
            descripcioncotizacion = request.POST.get('descripcionCotizacion')
            idcliente = request.POST.get('cliente')
            idestadocotizacion = request.POST.get('estado')

            cliente = Clientes.objects.get(idcliente=idcliente)
            estado = Estadoscotizaciones.objects.get(idestadocotizacion=idestadocotizacion)

            # Crear la cotización con los datos recibidos
            cotizacion = Cotizaciones.objects.create(
                totalcotizacion=totalcotizacion,
                descripcioncotizacion=descripcioncotizacion,
                idcliente=cliente,
                idestadocotizacion=estado
            )
            return redirect( 'asignar_productos_servicios', idcotizacion = cotizacion.idcotizacion)
            
        return render(request, 'cotizaciones.html')

    def asignar_productos_servicios(self, request, idcotizacion):
        if request.method == 'POST':
            servicios_seleccionados = request.POST.getlist('servicio')
            productos_seleccionados = request.POST.getlist('producto')
            cantidades_productos = request.POST.getlist('cantidad')

            if not productos_seleccionados and not servicios_seleccionados:
                messages.error(request, 'Debes seleccionar al menos un producto o servicio.')
                return render(request, 'cotizaciones.html')

            for idproducto, cantidad in zip(productos_seleccionados, cantidades_productos):
                producto = Productos.objects.get(idproducto = idproducto)
                producto_cotizacion = CotizacionesProductos.objects.create(
                    idcotizacion = idcotizacion,
                    idproducto = producto,
                    cantidad = cantidad
                )
                
        
            for idservicio in servicios_seleccionados:
                servicio = Servicios.objects.get(idservicio = idservicio)
                servicio_cotizacion = CotizacionesServicios.objects.create(
                    idcotizacion = idcotizacion,
                    idservicio = servicio
                )
                
        productos = Productos.objects.all()
        servicios = Servicios.objects.all()
        return render(request, 'cotizaciones.html',{'productos': productos, 'servicios': servicios})