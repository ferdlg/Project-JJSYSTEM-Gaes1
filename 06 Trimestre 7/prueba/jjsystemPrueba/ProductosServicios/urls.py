from django.urls import path, include
from rest_framework.routers import DefaultRouter
from . import views

from .controllers.categoriasproductos import categoriaproductosCRUD
from .controllers.categoriasservicios import categoriaserviciosCRUD
from .controllers.clientes import clientesCRUD
from .controllers.permisos import permisosCRUD
from .controllers.productos import productosCRUD
from .controllers.proveedoresproductos import proveedoresCRUD
from .controllers.rol_has_permisos import rol_has_permisosCRUD
from .controllers.roles import rolesCRUD
from .controllers.servicios import serviciosCRUD

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

urlpatterns=[
    path('', views.home, name='home'),
    path('productos', views.home_productos, name='homeProductos'),
    path('landing/',views.menuLanding, name='menuLanding'),
    path('api/', include(router.urls)),

    path('createProducto/', views.createProductoView, name='createProducto'),
    path('editarProducto/<idProducto>', views.editarProducto, name='editarProducto'),
    path('eliminarProducto/<idProducto>', views.eliminarProducto, name='eliminarProducto'),

    path('categoriaProducto/', views.home_categoriaProductos, name='categoriaProductos'),
    path('crearCategoriaProducto/', views.createCategoriaProductoView, name = 'createCategoriaProducto'),
    path('editarCategoriaProducto/<idCategoriaProducto>', views.editarCategoriaProductoView, name='editarCategoriaProducto'),
    path('eliminarCategoriaProducto/<idCategoriaProducto>', views.eliminarCategoriaProductoView, name = 'eliminarCategoriaProducto'),

    path('servicios/', views.home_servicios, name='homeServicios'),
    path('createServicio/', views.createServiciosView, name='createServicio'),
    path('editarServicio/<idServicio>', views.editarServicio, name='editarServicio'),
    path('eliminarServicio/<idServicio>', views.eliminarServicio, name='eliminarServicio'),

    path('categoriaServicio/', views.home_categoriaServicios, name = 'categoriaServicios'),
    path('createCategoriaServicio/', views.createCategoriaServicioView, name="createCategoriaServicio"),
    path('editarCategoriaServicio/<idCategoriaServicio>', views.editarCategoriaServicioView, name='editarCategoriaServicio'),
    path('eliminarCategoriaServicio/<idCategoriaServicio>', views.eliminarCategoriaServicioView, name = 'eliminarCategoriaServicio')

]