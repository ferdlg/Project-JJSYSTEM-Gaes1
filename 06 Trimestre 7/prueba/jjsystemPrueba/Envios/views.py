from django.contrib.auth.decorators import login_required
from django.shortcuts import render, redirect
from .models import Envios
from .models import Estadosenvios
from .models import Tecnicos
from Account.views import role_required
# Create your views here.

@login_required
@role_required(1)
def homeEnvios(request):
    search_query = request.GET.get('search', '')

    if search_query:
        envios = Envios.objects.filter(idenvio__iexact=search_query)
    else:
        envios = Envios.objects.all()

    return render(request, "crudAdmin/Index.html", {"envios": envios, "search_query": search_query})

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

            return redirect('homeEnvios')

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

        return redirect('homeEnvios')

    return render(request, "crudAdmin/Editar.html", {"envio": envio, "estados": estados})

def eliminarEnvio(request, idEnvio):
    envio = Envios.objects.get(idenvio = idEnvio)
    envio.delete()

    return redirect('homeEnvios')

