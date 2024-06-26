from django.shortcuts import redirect, render
from rest_framework import viewsets
from Account.models import Categoriasservicios
from .serializers import CategoriasServiciosSerializers
from django.core.paginator import Paginator , EmptyPage , PageNotAnInteger


class categoriaserviciosCRUD(viewsets.ModelViewSet):
    queryset = Categoriasservicios.objects.all()
    serializer_class = CategoriasServiciosSerializers



#crud categorias servicios 
def home_categoriaServicios(request):
    # Obtener todas las categorías de servicios
    categoria_list = Categoriasservicios.objects.all()

    # Configurar la paginación
    paginator = Paginator(categoria_list, 10)  # Mostrar 10 categorías por página
    page_number = request.GET.get('page')      # Obtener el número de página solicitado
    try:
        categorias = paginator.page(page_number)
    except PageNotAnInteger:
        categorias = paginator.page(1)
    except EmptyPage:
        categorias = paginator.page(paginator.num_pages)

    return render(request, "crudAdmin/categoriasServicios.html", {"categorias": categorias})

def createCategoriaServicioView(request):
    if request.method == 'POST':
        nombrecategoria = request.POST.get('nombreCategoria')
        # Crear la instancia de categoría de servicio
        categoria = Categoriasservicios.objects.create(
                nombrecategoria = nombrecategoria
            )
        return redirect('categoriaServicios')

    return render(request, "crudAdmin/categoriasServicios.html")

def editarCategoriaServicioView(request, idCategoriaServicio):
    categoria = Categoriasservicios.objects.get(idcategoriaservicio=idCategoriaServicio)
    if request.method == 'POST':
        # Obtener los datos de la petición
        nombrecategoria = request.POST.get('nombreCategoria')
        # Actualizar los campos del objeto categoría de servicio
        categoria.nombrecategoria = nombrecategoria
        categoria.save()

        return redirect('categoriaServicios')

    return render(request, "crudAdmin/categoriasServicios.html", {"categoria": categoria})

def eliminarCategoriaServicioView(request, idCategoriaServicio):
    categoria = Categoriasservicios.objects.get(idcategoriaservicio=idCategoriaServicio)
    categoria.delete()

    return redirect('categoriaServicios')