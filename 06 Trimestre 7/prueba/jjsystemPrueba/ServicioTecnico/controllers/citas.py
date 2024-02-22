from django.shortcuts import render
from rest_framework import viewsets
from ..models import Citas , Servicios, Cotizaciones, Categoriasservicios
from .serializers import CitasSerializer

class citasCRUD(viewsets.ModelViewSet):
    queryset = Citas.objects.all()
    serializer_class = CitasSerializer

    #Metodo para obtener solo las citas de analisis
    def cita_analisis(self, request):
        #Obtener datos de la cita
        citas_queryset = Citas.objects.filter(idcotizacion__idservicio__idcategoriaservicio = 3)
        citas_serializer = CitasSerializer(citas_queryset, many = True)
        citas_data = citas_serializer.data
        return render(request, 'citaAnalisis.html', {'citas': citas_data})
    
    #Metodo para obtener solo las citas de instalacion
    def cita_instalacion(self, request):
        #Obtener datos de la cita
        citas_queryset = Citas.objects.filter(idcotizacion__idservicio__idcategoriaservicio = 2)
        citas_serializer = CitasSerializer(citas_queryset, many = True)
        citas_data = citas_serializer.data
        return render(request, 'citaInstalacion.html', {'citas': citas_data})
        
    #Metodo para obtener solo las citas de mantenimiento
    def cita_mantenimiento(self, request):
        #Obtener datos de la cita
        citas_queryset = Citas.objects.filter(idcotizacion__idservicio__idcategoriaservicio = 4)
        citas_serializer = CitasSerializer(citas_queryset, many = True)
        citas_data = citas_serializer.data
        return render(request, 'citaMantenimiento.html', {'citas': citas_data})
    
    def crear_cita(self, request):
        citas_queryset = Citas.objects.create(
                                    fechacita = fechacita,
                                    direccioncita= direccioncita,
                                    contactocliente= contactocliente,
                                    descripcioncita= descripcioncita,
                                    idtecnico= idtecnico,
                                    idadministrador= idadministrador,
                                    idcotizacion= idcotizacion
                                    )
        return 
    
    def editar_cita(self, request):
        return render(request, 'EditCitas.html')
    
    def eliminar_cita(self, request):
        return