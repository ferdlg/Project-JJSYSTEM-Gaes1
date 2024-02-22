from django.shortcuts import render, redirect
from .models import Pqrsf
from .models import Estadospqrsf
from .models import Tipospqrsf

# Create your views here

def index(request):
    return render(request, 'index.html')

def edit(request):
    return render(request, 'edit.html')

def create(request):
    return render(request, 'create.html')  

def home(request):
    pqrsf = Pqrsf.objects.all()
    return render(request, "crudAdmin/Index.html", {"pqrsf": pqrsf})

def createPqrsfView(request):
    if request.method == 'POST':
        fechapqrsf = request.POST.get('fecha')
        informacionpqrsf = request.POST.get('informacion')
        estadopqrsf = request.POST.get('estado')
        tipopqrsf = request.POST.get('tipo')

        # Obtener la instancia de EstadosPqrsf
        estado = EstadosPqrsf.objects.get(idestadopqrsf=idestadopqrsf)

        # Obtener la instancia de TiposPqrsf
        tipo = TiposPqrsf.objects.get(idtipopqrsf=idtipopqrsf)

        # Crear la instancia de Pqrsf
        pqrsf = Pqrsf.objects.create(
            fechapqrsf=fecha,
            informacionpqrsf=informacion,
            estadopqrsf=estado,
            tipopqrsf=tipo
        )

        return redirect('homePqrsf')


    estados = EstadosPqrsf.objects.all()
    tipos = TiposPqrsf.objects.all()
    return render(request, "crudAdmin/Create.html", {"estados": estados, "tipos": tipos})    

def editarPqrsf(request, idPQRSF):
    pqrsf = Pqrsf.objects.get(idpqrsf=idPQRSF)
    estados = EstadosPqrsf.objects.all()
    tipos = TiposPqrsf.objects.all()

    if request.method == 'POST':
        #obtener los datos de la petición
        fechapqrsf = request.POST.get('fecha')
        informacionpqrsf = request.POST.get('informacion')
        estadopqrsf = request.POST.get('estado')
        tipopqrsf = request.POST.get('tipo')

        #obtener la instancia de EstadosPqrsf
        idestadopqrsf = EstadosPqrsf.objects.get(idestadopqrsf=idestadopqrsf)

        #obtener la instancia de TiposPqrsf
        idtipopqrsf = TiposPqrsf.objects.get(idtipopqrsf=idtipopqrsf)

        #actualizar los campos del objeto pqrsf
        pqrsf.fechapqrsf = fecha
        pqrsf.infomacionpqrsf = informacion
        pqrsf.estadopqrsf = estado
        pqrsf.tipopqrsf = tipo
        pqrsf.save()

        return redirect('homePqrsf')

    return render(request, "crudAdmin/Editar.html", {"pqrsf": pqrsf, "estados": estados, "tipos": tipos})

def eliminarPqrsf(request, idPQRSF):
    pqrsf = Pqrsf.objects.get(idpqrsf = idPQRSF)
    pqrsf.delete()

    return redirect('homePqrsf')