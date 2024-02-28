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
    return render(request, "createPqrsf.html", {"estados": estados, "tipos": tipos})    

def editarPqrsf(request, idPqrsf):
    pqrsf_item = Pqrsf.objects.get(idpqrsf=idPqrsf)
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
        pqrsf_item.fechapqrsf = fechapqrsf
        pqrsf_item.informacionpqrsf = informacionpqrsf
        pqrsf_item.idestadopqrsf = idestadopqrsf
        pqrsf_item.idtipopqrsf = idtipopqrsf
        pqrsf_item.save()

        return redirect('indexPqrsf')

    return render(request, "editarPqrsf.html", {"pqrsf": pqrsf_item, "estados": estados, "tipos": tipos})

def eliminarPqrsf(request, idpqrsf):
    pqrsf = Pqrsf.objects.get(idpqrsf = idpqrsf)
    pqrsf.delete()

    return redirect('indexPqrsf')