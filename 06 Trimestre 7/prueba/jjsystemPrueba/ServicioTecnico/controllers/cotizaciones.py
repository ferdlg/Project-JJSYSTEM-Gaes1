from rest_framework import viewsets
from django.shortcuts import render, redirect
from django.core.paginator import Paginator, EmptyPage, PageNotAnInteger
from Account.models import Cotizaciones, Clientes, Estadoscotizaciones
from .serializers import CotizacionesSerializer


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
        return render(request, 'cotizaciones.html', {'cotizaciones': cotizaciones})

    def crear_cotizaciones(self, request):
        if request.method == 'POST':
            totalcotizacion = request.POST.get('totalCotizacion')
            descripcioncotizacion = request.POST.get('descripcionCotizacion')
            idcliente = request.POST.get('cliente')
            idestadocotizacion = request.POST.get('estado')

            cliente = Clientes.objects.get(idcliente=idcliente)
            estado = Estadoscotizaciones.objects.get(idestadocotizacion=idestadocotizacion)

            # Crear la cotización con los datos recibidos
            Cotizaciones.objects.create(
                totalcotizacion=totalcotizacion,
                descripcioncotizacion=descripcioncotizacion,
                idcliente=cliente,
                idestadocotizacion=estado
            )
            return redirect('listar_cotizaciones')

        estados = Estadoscotizaciones.objects.all()
        clientes = Clientes.objects.all()
        return render(request, 'cotizaciones.html', {'estados': estados, 'clientes': clientes})
