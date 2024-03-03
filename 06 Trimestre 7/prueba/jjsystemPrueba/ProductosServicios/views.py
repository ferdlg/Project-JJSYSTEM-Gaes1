from django.shortcuts import render, redirect
from .models import Productos, Servicios
from .models import Categoriasproductos , Categoriasservicios
from .models import Proveedoresproductos
from django.core.paginator import Paginator , EmptyPage , PageNotAnInteger


# Create your views here.
def landing(request):
    return render(request, 'landing/Index.html')

def servicios(request):
    return render(request, 'landing/Servicios.html')

def productos(request):
    return render(request, 'landing/Productos.html')

def home(request):
    return render(request, "crudAdmin/IndexProductosServicios.html")

def home_productos(request):
    # Obtener todos los productos
    productos_list = Productos.objects.all()

    # Configurar la paginación
    paginator = Paginator(productos_list, 10)  # Mostrar 10 productos por página
    page_number = request.GET.get('page')      # Obtener el número de página solicitado
    try:
        productos = paginator.page(page_number)
    except PageNotAnInteger:
        productos = paginator.page(1)
    except EmptyPage:
        productos = paginator.page(paginator.num_pages)

    return render(request, "crudAdmin/IndexProductos.html", {"productos": productos})

def home_servicios(request):
    # Obtener todos los productos
    servicios_list = Servicios.objects.all()

    # Configurar la paginación
    paginator = Paginator(servicios_list, 10)  # Mostrar 10 productos por página
    page_number = request.GET.get('page')      # Obtener el número de página solicitado
    try:
        servicios = paginator.page(page_number)
    except PageNotAnInteger:
        servicios = paginator.page(1)
    except EmptyPage:
        servicios = paginator.page(paginator.num_pages)

    return render(request, "crudAdmin/IndexServicios.html", {"servicios": servicios})

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


def createServiciosView(request):
    if request.method == 'POST':
        nombreservicio = request.POST.get('nombre')
        descripcionservicio = request.POST.get('descripcion')
        idcategoriaservicio = request.POST.get('categoria')
            
        # Obtener la instancia de categorias
        categoria = Categoriasservicios.objects.get(idcategoriaservicio=idcategoriaservicio)

        # Crear la instancia de producto
        servicio = Servicios.objects.create(
                nombreservicio = nombreservicio,
                descripcionservicio = descripcionservicio,
                idcategoriaservicio = categoria
            )
        return redirect('homeServicios')

    categorias = Categoriasservicios.objects.all()
    return render(request, "crudAdmin/CreateServicio.html", {"categorias": categorias})

def editarServicio(request, idServicio):
    servicio = Servicios.objects.get(idservicio=idServicio)
    categorias = Categoriasservicios.objects.all()

    if request.method == 'POST':
        # Obtener los datos de la petición
        nombreservicio = request.POST.get('nombre')
        descripcionservicio = request.POST.get('descripcion')
        idcategoriaservicio = request.POST.get('categoria')

        # Obtener la instancia de categorias
        categoria = Categoriasproductos.objects.get(idcategoriservicio=idcategoriaservicio)

        # Actualizar los campos del objeto envio
        servicio.nombreproducto = nombreservicio
        servicio.descripcionproducto = descripcionservicio
        servicio.idcategoriaproducto = categoria
        servicio.save()

        return redirect('homeServicios')

    return render(request, "crudAdmin/EditarServicio.html", {"servicio": servicio, "categorias": categorias})

def eliminarServicio(request, idServicio):
    servicio = Servicios.objects.get(idservicio = idServicio)
    servicio.delete()

    return redirect('homeServicios')

def home_categoriaProductos(request):
    # Obtener todos los productos
    categoria_list = Categoriasproductos.objects.all()

    # Configurar la paginación
    paginator = Paginator(categoria_list, 10)  # Mostrar 10 productos por página
    page_number = request.GET.get('page')      # Obtener el número de página solicitado
    try:
        categorias = paginator.page(page_number)
    except PageNotAnInteger:
        categorias = paginator.page(1)
    except EmptyPage:
        categorias = paginator.page(paginator.num_pages)

    return render(request, "crudAdmin/categoriasProductos.html", {"categorias": categorias})


def createCategoriaProductoView(request):
    if request.method == 'POST':
        nombrecategoria = request.POST.get('nombreCategoria')
        # Crear la instancia de producto
        categoria = Categoriasproductos.objects.create(
                nombrecategoria = nombrecategoria
            )
        return redirect('categoriaProductos')

    return render(request, "crudAdmin/categoriasProductos.html", {"categorias": categoria})

def editarCategoriaProductoView(request, idCategoriaProducto):
    categoria = Categoriasproductos.objects.get(idcategoriaproducto=idCategoriaProducto)
    if request.method == 'POST':
        # Obtener los datos de la petición
        nombrecategoria = request.POST.get('nombreCategoria')  # Corregido aquí
        # Actualizar los campos del objeto envio
        categoria.nombrecategoria = nombrecategoria
        categoria.save()

        return redirect('categoriaProductos')

    return render(request, "crudAdmin/categoriasProductos.html", {"categoria": categoria})

def eliminarCategoriaProductoView(request, idCategoriaProducto):
    categoria = Categoriasproductos.objects.get(idcategoriaproducto = idCategoriaProducto)
    categoria.delete()

    return redirect('categoriaProductos')