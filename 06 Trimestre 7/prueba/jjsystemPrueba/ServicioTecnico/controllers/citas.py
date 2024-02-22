from django.shortcuts import render, redirect
from rest_framework import viewsets
from ..models import Citas , Servicios, Cotizaciones, Categoriasservicios, Tecnicos, Administrador , Estadoscitas
from .serializers import CitasSerializer
from rest_framework.decorators import api_view


class citasCRUD(viewsets.ModelViewSet):
    queryset = Citas.objects.all()
    serializer_class = CitasSerializer

    #Metodo para obtener solo las citas de analisis
    def cita_analisis(self, request):
        #Obtener datos de la cita
        citas_queryset = Citas.objects.filter(idcotizacion__idservicio__idcategoriaservicio = 3)
        citas_serializer = CitasSerializer(citas_queryset, many = True)
        citas_data = citas_serializer.data
        print(citas_data)
        return render(request, 'citaAnalisis.html', {'citas': citas_data})
    
    #Metodo para obtener solo las citas de instalacion
    def cita_instalacion(self, request):
        #Obtener datos de la cita
        citas_queryset = Citas.objects.filter(idcotizacion__idservicio__idcategoriaservicio = 2)
        citas_serializer = CitasSerializer(citas_queryset, many = True)
        citas_data = citas_serializer.data
        print(citas_data)
        return render(request, 'citaInstalacion.html', {'citas': citas_data})
        
    #Metodo para obtener solo las citas de mantenimiento
    def cita_mantenimiento(self, request):
        #Obtener datos de la cita
        citas_queryset = Citas.objects.filter(idcotizacion__idservicio__idcategoriaservicio = 4)
        citas_serializer = CitasSerializer(citas_queryset, many = True)
        citas_data = citas_serializer.data
        return render(request, 'citaMantenimiento.html', {'citas': citas_data})
    
    
    def crear_citas(self, request):
        if request.method == 'POST':
            fechacita = request.POST.get('fechacita')
            direccioncita = request.POST.get('direccioncita')
            contactocliente = request.POST.get('contactocliente')
            descripcioncita = request.POST.get('descripcioncita')
            idtecnico = request.POST.get('idtecnico')
            idadministrador = request.POST.get('idadministrador')
            idcotizacion = request.POST.get('idcotizacion')
            idestadocita = request.POST.get('idestadocita')
            try:
                idtecnico = int(idtecnico)
                tecnico = Tecnicos.objects.get(idtecnico=idtecnico)
                idadministrador = int(idadministrador)
                administrador = Administrador.objects.get(idadministrador=idadministrador)
                idcotizacion = int(idcotizacion)
                cotizacion = Cotizaciones.objects.get(idcotizacion=idcotizacion)
                idestadocita = int(idestadocita)
                estadocita = Estadoscitas.objects.get(idestadocita=idestadocita)
                # Crear la instancia de la cita
                cita = Citas.objects.create(
                    fechacita=fechacita,
                    direccioncita=direccioncita,
                    contactocliente=contactocliente,
                    descripcioncita=descripcioncita,
                    idtecnico=tecnico,
                    idadministrador=administrador,
                    idcotizacion=cotizacion,
                    idestadocita=estadocita
                )

                return redirect('cita_analisis')

            except Tecnicos.DoesNotExist:
                print("Error: No se encontró el Técnico.")
            except Estadoscitas.DoesNotExist:
                print("Error: No se encontró el estado de la cita.")

        estados = Estadoscitas.objects.all()
        return render(request, 'citaAnalisis.html', {'estados': estados})
        
    @api_view(['PUT'])
    def editar_cita(self, request , idcita):
        cita_actualizada = Citas.objects.update(idcita = idcita)
        return render(request, 'EditCitas.html')
    
    @api_view(['DELETE'])
    def eliminar_cita(self, request, idcita):
        cita_eliminada = Citas.objects.delete(idcita = idcita)
        return render()