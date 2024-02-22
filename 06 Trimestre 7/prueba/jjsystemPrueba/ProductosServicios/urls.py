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
    path('api/', include(router.urls)),
]