from django.shortcuts import redirect, render
from rest_framework import viewsets
from Account.models import *
from .serializers import ProductosSerializer
from django.core.paginator import Paginator , EmptyPage , PageNotAnInteger


'''
    Importamos la biblioteca viewsets 
    de Django Rest Framework la cual nos proporciona las
    operaciones de un crud 
'''

#definimos la clase 
class productosCRUD(viewsets.ModelViewSet):
    # usamos queryset, que traera todos los objetos de la clase
    queryset = Productos.objects.all()
    # usamos serializer class para poder ver los objetos que se traen 
    serializer_class = ProductosSerializer

# Productos en dashboard admin
def home_productos(request):
    # Obtener todos los productos
    productos_list = Productos.objects.all()

    # Configurar la paginación
    paginator = Paginator(productos_list, 5)  # Mostrar 10 productos por página
    page_number = request.GET.get('page')      # Obtener el número de página solicitado
    try:
        productos = paginator.page(page_number)
    except PageNotAnInteger:
        productos = paginator.page(1)
    except EmptyPage:
        productos = paginator.page(paginator.num_pages)

    return render(request, "crudAdmin/IndexProductos.html", {"productos": productos})

# crud de productos
def createProductoView(request):
    if request.method == 'POST':
        nombreproducto = request.POST.get('nombre')
        descripcionproducto = request.POST.get('descripcion')
        precioproducto = request.POST.get('precio')
        cantidad = request.POST.get('cantidad')
        idcategoriaproducto = request.POST.get('categoria')
        idproveedorproducto = request.POST.get('proveedor')
            
        # Obtener la instancia de categorias
        categoria = Categoriasproductos.objects.get(idcategoriaproducto=idcategoriaproducto)

        # Obtener la instancia de proveedor
        proveedor = Proveedoresproductos.objects.get(idproveedorproducto=idproveedorproducto)

        # Crear la instancia de producto
        producto = Productos.objects.create(
                nombreproducto = nombreproducto,
                descripcionproducto = descripcionproducto,
                precioproducto = precioproducto,
                cantidad = cantidad,
                idcategoriaproducto = categoria,
                idproveedorproducto = proveedor
            )
        return redirect('homeProductos')

    categorias = Categoriasproductos.objects.all()
    proveedores = Proveedoresproductos.objects.all()
    return render(request, "crudAdmin/CreateProducto.html", {"categorias": categorias, "proveedores": proveedores})

def editarProducto(request, idProducto):
    producto = Productos.objects.get(idproducto=idProducto)
    categorias = Categoriasproductos.objects.all()
    proveedores = Proveedoresproductos.objects.all()

    if request.method == 'POST':
        # Obtener los datos de la petición
        nombreproducto = request.POST.get('nombre')
        descripcionproducto = request.POST.get('descripcion')
        precioproducto = request.POST.get('precio')
        cantidad = request.POST.get('cantidad')
        idcategoriaproducto = request.POST.get('categoria')
        idproveedorproducto = request.POST.get('proveedor')

        # Obtener la instancia de categorias
        categoria = Categoriasproductos.objects.get(idcategoriaproducto=idcategoriaproducto)

        # Obtener la instancia de proveedor
        proveedor = Proveedoresproductos.objects.get(idproveedorproducto=idproveedorproducto)

        # Actualizar los campos del objeto envio
        producto.nombreproducto = nombreproducto
        producto.descripcionproducto = descripcionproducto
        producto.precioproducto = precioproducto
        producto.cantidad = cantidad
        producto.idcategoriaproducto = categoria
        producto.idproveedorproducto = proveedor
        producto.save()

        return redirect('homeProductos')

    return render(request, "crudAdmin/EditarProducto.html", {"producto": producto, "categorias": categorias, "proveedores": proveedores})

def eliminarProducto(request, idProducto):
    producto = Productos.objects.get(idproducto = idProducto)
    producto.delete()

    return redirect('homeProductos')