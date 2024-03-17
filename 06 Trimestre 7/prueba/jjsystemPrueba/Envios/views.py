from django.contrib.auth.decorators import login_required
from django.shortcuts import render, redirect
from Account.models import Envios
from Account.models import Estadosenvios
from Account.models import Tecnicos
from Account.models import DetalleEnviosVentas
from Account.models import EnviosClientes
from Account.views import role_required
from django.http import HttpResponse
from django.template.loader import get_template
from xhtml2pdf import pisa
# Create your views here.

def homeEnvios(request):
    search_query = request.GET.get('search', '')

    if search_query:
        envios = Envios.objects.filter(idenvio__iexact=search_query)
    else:
        envios = Envios.objects.all()

    return render(request, "crudAdmin/Index.html", {"envios": envios, "search_query": search_query})

#@login_required
#@role_required(1)
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

#@login_required
#@role_required(1)
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

#@login_required
#@role_required(1)
def eliminarEnvio(request, idEnvio):
    envio = Envios.objects.get(idenvio = idEnvio)
    envio.delete()

    return redirect('homeEnvios')

def detallesView(request, idEnvio):
    detallesEnvio = DetalleEnviosVentas.objects.get(idenvio=idEnvio)
    return render(request, 'crudAdmin/Detalles.html', {'detallesEnvio': detallesEnvio})

def enviosEntregados(request):
    # Filtrar los envíos por estado "Entregado" 
    envios = Envios.objects.filter(idestadoenvio=3)

    return render(request, "crudAdmin/EnviosEntregados.html", {"envios": envios})


#Views del tecnico

#@login_required
#@role_required(1)
def homeEnviosTecnico(request):
    search_query = request.GET.get('search', '')

    if search_query:
        envios = Envios.objects.filter(idtecnico__exact=search_query)
    else:
        envios = Envios.objects.all()

    return render(request, "tecnico/IndexTecnico.html", {"envios": envios, "search_query": search_query})


#Views cliente

def enviosCliente(request, idCliente):
    # Filtrar los envíos del cliente utilizando el ID del cliente pasado en la URL
    enviosCliente = EnviosClientes.objects.filter(idcliente=idCliente)

    # Excluir los envíos con estado "Entregado"
    enviosCliente = enviosCliente.exclude(nombreestadoenvio="Entregado")

    return render(request, 'usuarios/EnviosCliente.html', {'envios_cliente': enviosCliente, 'idCliente': idCliente})

    
def historialEnviosCliente(request, idCliente):
    # Filtrar todos los envíos del cliente con estado "Entregado"
    historialEnviosCliente = EnviosClientes.objects.filter(idcliente=idCliente, nombreestadoenvio="Entregado")

    # Renderizar el template de historial de envíos con los envíos del cliente
    return render(request, 'usuarios/HistorialEnviosCliente.html', {'historial_envios_cliente': historialEnviosCliente})

#PDF

# views.py
def generar_pdf(request, templateName):
    # Obtener los datos de los envíos que deseas mostrar en la tabla de contenido
    envios = Envios.objects.all()  # Obtén todos los envíos, ajusta según tu lógica
    # Renderizar solo la tabla de contenido de la plantilla
    context = {'envios': envios}  # Pasar los datos de los envíos al contexto
    html_template = get_template(f'crudAdmin/{templateName}') 
    html_content = html_template.render(context)
    # Crear un objeto PDF
    response = HttpResponse(content_type='application/pdf')
    response['Content-Disposition'] = f'attachment; filename="{templateName}.pdf"'
    # Convertir HTML a PDF
    pisa.CreatePDF(html_content, dest=response)
    return response


