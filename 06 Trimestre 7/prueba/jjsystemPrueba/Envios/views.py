from django.shortcuts import render, redirect
from .models import Envios
from .models import Estadosenvios
from .models import Tecnicos

# Create your views here.

def home(request):
    envios = Envios.objects.all()
    return render(request, "crudAdmin/Index.html", {"envios": envios})

def createEnvioView(request):
    if request.method == 'POST':
        direccion = request.POST.get('direccion')
        idtecnico = request.POST.get('idtecnico')
        idestadoenvio = request.POST.get('estado')

        try:
            # Convertir idtecnico a entero
            idtecnico = int(idtecnico)
            
            # Obtener la instancia de Tecnicos
            idtecnico = Tecnicos.objects.get(idtecnico=idtecnico)

            # Obtener la instancia de Estadosenvios
            estado = Estadosenvios.objects.get(idestadoenvio=idestadoenvio)

            # Crear la instancia de Envios
            envio = Envios.objects.create(
                direccionenvio=direccion,
                idtecnico=idtecnico,
                idestadoenvio=estado
            )

            return redirect('home')

        except Tecnicos.DoesNotExist:
            print("Error: No se encontró el Técnico.")
        except Estadosenvios.DoesNotExist:
            print("Error: No se encontró el Estado de Envío.")

    estados = Estadosenvios.objects.all()
    return render(request, "crudAdmin/Create.html", {"estados": estados})

def editarEnvio(request, idEnvio):
    envio = Envios.objects.get(idenvio=idEnvio)
    estados = Estadosenvios.objects.all()

    if request.method == 'POST':
        # Obtener los datos de la petición
        direccion = request.POST.get('direccion')
        idtecnico = int(request.POST.get('idtecnico'))
        idestadoenvio = int(request.POST.get('estado'))

        # Obtener las instancias de Tecnicos y Estadosenvios
        idtecnico = Tecnicos.objects.get(idtecnico=idtecnico)
        idestadoenvio = Estadosenvios.objects.get(idestadoenvio=idestadoenvio)

        # Actualizar los campos del objeto envio
        envio.direccionenvio = direccion
        envio.idtecnico = idtecnico
        envio.idestadoenvio = idestadoenvio
        envio.save()

        return redirect('home')

    return render(request, "crudAdmin/Editar.html", {"envio": envio, "estados": estados})

def eliminarEnvio(request, idEnvio):
    envio = Envios.objects.get(idenvio = idEnvio)
    envio.delete()

    return redirect('home')
