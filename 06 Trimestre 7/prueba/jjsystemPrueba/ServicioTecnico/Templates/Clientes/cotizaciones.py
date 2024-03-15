from django.shortcuts import render, redirect
from django.views import View
from Account.models import Cotizaciones, CotizacionesProductos, CotizacionesServicios, Productos, Servicios
from Account.forms import CrearCotizacionForm

class ClienteCotizacionCRUD(View):
    def get(self, request):
        # Obtener todos los productos y servicios disponibles
        productos = Productos.objects.all()
        servicios = Servicios.objects.all()
        # Renderizar el formulario de cotización
        return render(request, 'formulario_cotizacion.html', {'productos': productos, 'servicios': servicios})

    def post(self, request):
        # Procesar la solicitud POST para agregar productos o servicios a la cotización
        if request.method == 'POST':
            # Crear una nueva instancia de cotización con los datos recibidos
            cotizacion = Cotizaciones.objects.create(
                totalcotizacion=0,  # Ajustar según la lógica de tu aplicación
                descripcioncotizacion=request.POST.get('descripcioncotizacion'),  # Ajustar según el nombre de tu campo de descripción
                idcliente=request.user.cliente,  # Asignar cliente actual
                idestadocotizacion_id=1  # Ajustar según el estado inicial de la cotización
            )
            
            # Procesar los productos seleccionados
            productos_seleccionados = request.POST.getlist('producto[]')
            for idproducto in productos_seleccionados:
                cantidad = request.POST.get('cantidad_' + idproducto)
                if cantidad:  # Verificar si se ingresó una cantidad
                    producto = Productos.objects.get(id=idproducto)
                    CotizacionesProductos.objects.create(
                        idcotizacion=cotizacion,
                        idproducto=producto,
                        cantidad=cantidad
                    )
            
            # Procesar los servicios seleccionados
            servicios_seleccionados = request.POST.getlist('servicio[]')
            for idservicio in servicios_seleccionados:
                servicio = Servicios.objects.get(id=idservicio)
                CotizacionesServicios.objects.create(
                    idcotizacion=cotizacion,
                    idservicio=servicio
                )

            # Redirigir a la página de inicio u otra página deseada
            return redirect('index')

        # Si no es una solicitud POST, renderizar el formulario de cotización
        productos = Productos.objects.all()
        servicios = Servicios.objects.all()
        return render(request, 'formulario_cotizacion.html', {'productos': productos, 'servicios': servicios})
