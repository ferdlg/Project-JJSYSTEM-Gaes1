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
        
    
    def editar_citas(request, idcita):
        cita = Citas.objects.get(idcita=idcita)
        estados = Estadoscitas.objects.all()

        if request.method == 'POST':
            # Obtener los datos de la petición
            fechacita = request.POST.get('fechacita')
            direccioncita = request.POST.get('direccioncita')
            contactocliente = request.POST.get('contactocliente')
            descripcioncita = request.POST.get('descripcioncita')
            idtecnico = int(request.POST.get('idtecnico'))
            idadministrador = int(request.POST.get('idadministrador'))
            idcotizacion = int(request.POST.get('idcotizacion'))
            idestadocita = int(request.POST.get('idestadocita'))

            # Obtener las instancias de Tecnicos, Administrador, Cotizaciones y Estadoscitas
            idtecnico = Tecnicos.objects.get(idtecnico=idtecnico)
            idadministrador = Administrador.objects.get(idadministrador=idadministrador)
            idcotizacion = Cotizaciones.objects.get(idcotizacion=idcotizacion)
            idestadocita = Estadoscitas.objects.get(idestadocita=idestadocita)

            # Actualizar los campos del objeto cita
            cita.fechacita = fechacita
            cita.direccioncita = direccioncita
            cita.contactocliente = contactocliente
            cita.descripcioncita = descripcioncita
            cita.idtecnico = idtecnico
            cita.idadministrador = idadministrador
            cita.idcotizacion = idcotizacion
            cita.idestadocita = idestadocita
            cita.save()

            return redirect('index')  

        return render(request,'Templates/EditarCitas.html', {"citas": cita})

    def eliminar_citas(self, request, idcita):
        cita_eliminada = Citas.objects.delete(idcita = idcita)
        cita_eliminada.delete()
        return render('index')