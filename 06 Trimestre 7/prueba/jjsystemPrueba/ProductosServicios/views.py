from django.shortcuts import render, redirect
from .models import Productos
from .models import Categoriasproductos
from .models import Proveedoresproductos
# Create your views here.
def landing(request):
    return render(request, 'landing/Index.html')

def servicios(request):
    return render(request, 'landing/Servicios.html')

def productos(request):
    return render(request, 'landing/Productos.html')

def home(request):
    productos = Productos.objects.all()
    return render(request, "crudAdmin/IndexProductos.html", {"productos": productos})

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
    envio = Productos.objects.get(idproducto = idProducto)
    envio.delete()

    return redirect('homeProductos')
