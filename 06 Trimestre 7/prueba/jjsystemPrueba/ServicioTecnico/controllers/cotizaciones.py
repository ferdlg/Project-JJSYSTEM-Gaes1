from urllib import response
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
        productos = Productos.objects.all()
        servicios = Servicios.objects.all()

        return render(request, 'cotizaciones.html', {'productos':productos, 'servicios':servicios})

    def asignar_productos_servicios(self,request, idcotizacion):
        if request.method == 'POST':
            productos_seleccionados = request.POST.getlist('producto[]')
            servicios_seleccionados = request.POST.getlist('servicio[]')

            cotizacion = Cotizaciones.objects.get(idcotizacion=idcotizacion)

            for idproducto in productos_seleccionados:
                cantidad = request.POST.get('cantidad_' + idproducto)
                if cantidad:  # Verifica si se ingresó una cantidad
                    producto = Productos.objects.get(idproducto=idproducto)
                    producto_cotizacion = CotizacionesProductos.objects.create(
                        idcotizacion=cotizacion,
                        idproducto=producto,
                        cantidad=cantidad
                    )
                else:
                    print("No se ha ingresado una cantidad para el producto", idproducto)

            for idservicio in servicios_seleccionados:
                servicio = Servicios.objects.get(idservicio=idservicio)
                servicio_cotizacion = CotizacionesServicios.objects.create(
                    idcotizacion=cotizacion,
                    idservicio=servicio
                )

            productos = Productos.objects.all()
            servicios = Servicios.objects.all()

            return redirect('index')
            

        else:
            productos = Productos.objects.all()
            servicios = Servicios.objects.all()
            return render(request, 'asignarProductosServicios.html', {'productos': productos, 'servicios': servicios, 'idcotizacion': idcotizacion})
