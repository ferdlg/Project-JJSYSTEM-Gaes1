from django.urls import path, include
from rest_framework.routers import DefaultRouter
from . import views

from .controllers.categoriasproductos import categoriaproductosCRUD , home_categoriaProductos , createCategoriaProductoView , editarCategoriaProductoView, eliminarCategoriaProductoView
from .controllers.categoriasservicios import categoriaserviciosCRUD , home_categoriaServicios, createCategoriaServicioView, editarCategoriaServicioView, eliminarCategoriaServicioView
from .controllers.clientes import clientesCRUD
from .controllers.permisos import permisosCRUD
from .controllers.productos import productosCRUD , home_productos , createProductoView, editarProducto, eliminarProducto
from .controllers.ventas import ventasCRUD, home_ventas,createVenta, editVenta, deleteVenta
from .controllers.proveedoresproductos import proveedoresCRUD
from .controllers.rol_has_permisos import rol_has_permisosCRUD
from .controllers.roles import rolesCRUD
from .controllers.servicios import serviciosCRUD, servicios, servicios_landing, home_servicios, createServiciosView, editarServicio, eliminarServicio
from .controllers.cotizaciones import CotizacionesCRUD

router = DefaultRouter()
router.register(r'categoriasproductos', categoriaproductosCRUD)
router.register(r'categoriasservicios', categoriaserviciosCRUD)
router.register(r'clientes', clientesCRUD)
router.register(r'permisos', permisosCRUD)
router.register(r'productos', productosCRUD)
router.register(r'proveedoresproductos', proveedoresCRUD)
router.register(r'rol_has_permisos', rol_has_permisosCRUD)
router.register(r'roles', rolesCRUD)
router.register(r'servicios', serviciosCRUD)
router.register(r'ventas', ventasCRUD)


urlpatterns=[
    path('', views.home, name='home'),
    path('productos',home_productos, name='homeProductos'),
    path('ventas', home_ventas, name='homeVentas' ),
    path('createVenta/', createVenta, name='createVenta' ),
    path('editarVenta/<int:idVenta>/', editVenta, name='editarVenta'),
    path('deleteVenta/<int:idVenta>/', deleteVenta, name='deleteVenta'),
    path('serviciosLanding/<int:categoria>/',servicios_landing, name='serviciosLanding'),
    path('buscar/', views.buscar_productos_servicios, name='buscar'),
    path('verProducto/<id>/', views.producto, name='verProducto'),
    path('api/', include(router.urls)),

    path('createProducto/',createProductoView, name='createProducto'),
    path('editarProducto/<idProducto>',editarProducto, name='editarProducto'),
    path('eliminarProducto/<idProducto>',eliminarProducto, name='eliminarProducto'),

    path('categoriaProducto/', home_categoriaProductos, name='categoriaProductos'),
    path('crearCategoriaProducto/', createCategoriaProductoView, name = 'createCategoriaProducto'),
    path('editarCategoriaProducto/<idCategoriaProducto>', editarCategoriaProductoView, name='editarCategoriaProducto'),
    path('eliminarCategoriaProducto/<idCategoriaProducto>', eliminarCategoriaProductoView, name = 'eliminarCategoriaProducto'),

    path('servicios/', home_servicios, name='homeServicios'),
    path('createServicio/', createServiciosView, name='createServicio'),
    path('editarServicio/<idServicio>', editarServicio, name='editarServicio'),
    path('eliminarServicio/<idServicio>', eliminarServicio, name='eliminarServicio'),

    path('categoriaServicio/', home_categoriaServicios, name = 'categoriaServicios'),
    path('createCategoriaServicio/', createCategoriaServicioView, name="createCategoriaServicio"),
    path('editarCategoriaServicio/<idCategoriaServicio>', editarCategoriaServicioView, name='editarCategoriaServicio'),
    path('eliminarCategoriaServicio/<idCategoriaServicio>', eliminarCategoriaServicioView, name = 'eliminarCategoriaServicio'),

    path('cotizacion/', CotizacionesCRUD.as_view({'post':'crear_cotizacion', 'get':'crear_cotizacion'}), name='crear_cotizacion'),
    path('verCotizacion/<idcotizacion>', CotizacionesCRUD.as_view({'post':'mostrar_cotizacion', 'get':'mostrar_cotizacion'}), name='cotizacion'),
    path('agregar_elemento/<str:tipo_elemento>/<int:id_elemento>/', CotizacionesCRUD.as_view({'post': 'agregar_elemento','get': 'agregar_elemento'}), name='agregar_elemento'),
    path('quitar_elemento/<tipo_elemento>/<int:id_elemento>/', CotizacionesCRUD.as_view({'post': 'quitar_elemento','get': 'quitar_elemento'}), name='quitar_elemento'),



]