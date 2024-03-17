from django.http import JsonResponse
from django.shortcuts import get_object_or_404, redirect, render
from ServicioTecnico.controllers.cotizaciones import CotizacionesCRUD as BaseCotizacionesCRUD
from Account.models import *

class CotizacionesCRUD(BaseCotizacionesCRUD):
    # Métodos heredados de la clase base

    def crear_cotizacion(self, request):
        return render (request,'cliente/crear_cotizacion.html')

    def agregar_elemento(self, request, id_elemento, tipo_elemento):
        elementos_seleccionados = request.session.get(f'{tipo_elemento}s_seleccionados', [])
        if id_elemento:
            elementos_seleccionados.append(id_elemento)
            request.session[f'{tipo_elemento}s_seleccionados'] = elementos_seleccionados

        elementos = []
        if tipo_elemento == 'producto':
            ElementoModel = Productos
            for id_elemento_seleccionado in elementos_seleccionados:
                producto = ElementoModel.objects.get(pk=id_elemento_seleccionado)
                cantidad = request.POST.get(f'cantidad_{ producto.idproducto }')
                elementos.append({'id': producto.idproducto, 'nombre': producto.nombreproducto, 'cantidad': cantidad})
        elif tipo_elemento == 'servicio':
            ElementoModel = Servicios
            for id_elemento_seleccionado in elementos_seleccionados:
                servicio = ElementoModel.objects.get(pk=id_elemento_seleccionado)
                cantidad = request.POST.get(f'cantidad_{servicio.idservicio}')
                elementos.append({'id': servicio.idservicio, 'nombre': servicio.nombreservicio})

        context = {
            'productos_all': Productos.objects.all(),
            'servicios_all': Servicios.objects.all(),
            tipo_elemento + 's': elementos
        }
        return render(request, 'cliente/crear_cotizacion.html', context)

    def quitar_elemento(self, request, id_elemento, tipo_elemento):
        elementos_seleccionados = request.session.get(f'{tipo_elemento}s_seleccionados', [])
        if id_elemento in elementos_seleccionados:
            elementos_seleccionados.remove(id_elemento)
            request.session[f'{tipo_elemento}s_seleccionados'] = elementos_seleccionados

        elementos = []
        
        if tipo_elemento == 'producto':
            ElementoModel = Productos
            for id_elemento_seleccionado in elementos_seleccionados:
                producto = ElementoModel.objects.get(pk=id_elemento_seleccionado)
                cantidad = request.POST.get(f'cantidad_{producto.idproducto}')
                elementos.append({'id': producto.idproducto, 'nombre': producto.nombreproducto, 'cantidad': cantidad})
        elif tipo_elemento == 'servicio':
            ElementoModel = Servicios
            for id_elemento_seleccionado in elementos_seleccionados:
                servicio = ElementoModel.objects.get(pk=id_elemento_seleccionado)
                elementos.append({'id': servicio.idservicio, 'nombre': servicio.nombreservicio})

        context = {
            'productos_all': Productos.objects.all(),
            'servicios_all': Servicios.objects.all(),
            tipo_elemento + 's': elementos
        }
        return render(request, 'cliente/crear_cotizacion.html', context)

    def crear_cotizacion_cliente(request):
        if request.method == 'POST':
            numerodocumento = request.user.numerodocumento
            cliente = get_object_or_404(Clientes, numerodocumento=numerodocumento)
            idcliente = cliente.idcliente

            productos_seleccionados = request.session.get('productos_seleccionados', [])
            servicios_seleccionados = request.session.get('servicios_seleccionados', [])

            nueva_cotizacion = Cotizaciones.objects.create(
                idcliente=idcliente,
                totalcotizacion=0.0,  
                descripcioncotizacion=request.POST.get('descripcioncotizacion', '')
            )
            # Asociar los productos seleccionados con la nueva cotización
            for id_producto in productos_seleccionados:
                producto = Productos.objects.get(pk=id_producto)
                CotizacionesProductos.objects.create(idcotizacion=nueva_cotizacion, idproducto=producto, cantidad=1)

            # Asociar los servicios seleccionados con la nueva cotización
            for id_servicio in servicios_seleccionados:
                servicio = Servicios.objects.get(pk=id_servicio)
                CotizacionesServicios.objects.create(idcotizacion=nueva_cotizacion, idservicio=servicio)
                    
            return redirect('mostrar_cotizacion', id_cotizacion=nueva_cotizacion.idcotizacion)
        
        # Obtener la lista de productos seleccionados del request.session
        
        return render(request, 'crear_cotizacion.html', {'productos': Productos.objects.filter(pk__in=productos_seleccionados), 'servicios': Servicios.objects.all()})



    def obtener_productos_servicios_cotizacion(self, request, idcotizacion):
        productos_cotizacion = CotizacionesProductos.objects.filter(idcotizacion=idcotizacion)
        servicios_cotizacion = CotizacionesServicios.objects.filter(idcotizacion=idcotizacion)
        return productos_cotizacion, servicios_cotizacion

    def mostrar_cotizacion(self, request, idcotizacion):
        productos_cotizacion, servicios_cotizacion = self.obtener_productos_servicios_cotizacion(request, idcotizacion)
        if productos_cotizacion.exists() or servicios_cotizacion.exists():
            return render(request, 'ver_cotizacion.html', {'productos': productos_cotizacion, 'servicios': servicios_cotizacion})
        else:
            mensaje = 'Aún no has agregado productos ni servicios a esta cotización.'
            return render(request, 'mensaje.html', {'mensaje': mensaje})
