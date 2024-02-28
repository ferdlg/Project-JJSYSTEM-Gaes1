from django.shortcuts import render, redirect
from .models import Pqrsf
from .models import Estadospqrsf
from .models import Tipospqrsf

# Create your views here

def indexPqrsf(request):
    pqrsf_item = Pqrsf.objects.all()
    return render(request, 'indexPqrsf.html', {"pqrsf": pqrsf_item})

def editPqrsf(request):
    return render(request, 'editPqrsf.html')

def createPqrsf(request):
    return render(request, 'createPqrsf.html')  


def createPqrsfView(request):
    if request.method == 'POST':
        fechapqrsf = request.POST.get('fecha')
        informacionpqrsf = request.POST.get('informacion')
        estadopqrsf = request.POST.get('estado')
        tipopqrsf = request.POST.get('tipo')

        # Obtener la instancia de EstadosPqrsf
        estado = Estadospqrsf.objects.get(idestadopqrsf=estadopqrsf)

        # Obtener la instancia de TiposPqrsf
        tipo = Tipospqrsf.objects.get(idtipopqrsf=tipopqrsf)

        # Crear la instancia de Pqrsf
        pqrsf = Pqrsf.objects.create(
            fechapqrsf=fechapqrsf,
            informacionpqrsf=informacionpqrsf,
            estadopqrsf=estadopqrsf,
            tipopqrsf=tipopqrsf
        )

        return redirect('indexPqrsf')


    estados = Estadospqrsf.objects.all()
    tipos = Tipospqrsf.objects.all()
    return render(request, "templates/CreatePqrsf.html", {"estados": estados, "tipos": tipos})    

def editarPqrsf(request, idPQRSF):
    pqrsf = Pqrsf.objects.get(idpqrsf=idPQRSF)
    estados = Estadospqrsf.objects.all()
    tipos = Tipospqrsf.objects.all()

    if request.method == 'POST':
        #obtener los datos de la petición
        fechapqrsf = request.POST.get('fecha')
        informacionpqrsf = request.POST.get('informacion')
        idestadopqrsf = request.POST.get('estado')
        idtipopqrsf = request.POST.get('tipo')

        #obtener la instancia de EstadosPqrsf
        idestadopqrsf = Estadospqrsf.objects.get(idestadopqrsf=idestadopqrsf)

        #obtener la instancia de TiposPqrsf
        idtipopqrsf = Tipospqrsf.objects.get(idtipopqrsf=idtipopqrsf)

        #actualizar los campos del objeto pqrsf
        pqrsf.fechapqrsf = fechapqrsf
        pqrsf.informacionpqrsf = informacionpqrsf
        pqrsf.idestadopqrsf = idestadopqrsf
        pqrsf.idtipopqrsf = idtipopqrsf
        pqrsf.save()

        return redirect('indexPqrsf')

    return render(request, "templates/editarPqrsf.html", {"pqrsf": pqrsf, "estados": estados, "tipos": tipos})

def eliminarPqrsf(request, idpqrsf):
    pqrsf = Pqrsf.objects.get(idpqrsf = idpqrsf)
    pqrsf.delete()

    return redirect('indexPqrsf')