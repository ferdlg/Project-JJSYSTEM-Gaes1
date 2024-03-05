from rest_framework.response import Response
from rest_framework import viewsets, status
from django.shortcuts import render, redirect
from ..models import Cotizaciones
from .serializers import CotizacionesSerializer
from django.core.paginator import Paginator , EmptyPage , PageNotAnInteger



class cotizacionesCRUD(viewsets.ModelViewSet):
    queryset = Cotizaciones.objects.all()
    serializer_class = CotizacionesSerializer

    def listar_cotizaciones(self, request):
        cotizaciones_list = self.queryset
            # Configurar la paginación
        paginator = Paginator(cotizaciones_list, 5)  # Mostrar 10 productos por página
        page_number = request.GET.get('page')      # Obtener el número de página solicitado
        try:
            cotizaciones = paginator.page(page_number)
        except PageNotAnInteger:
            cotizaciones = paginator.page(1)
        except EmptyPage:
            cotizaciones = paginator.page(paginator.num_pages)
        return render(request, 'cotizaciones.html', {'cotizaciones': cotizaciones})
    
    def crear_cotizaciones(self, request, **kwargs):
        cotizacion_data = request.data
        serializer = self.get_serializer(data = cotizacion_data)

        print(serializer.data)
        if serializer.is_valid():
            serializer.save()
            return Response(serializer.data, status=status.HTTP_201_CREATED)
        else:
            return Response('error')