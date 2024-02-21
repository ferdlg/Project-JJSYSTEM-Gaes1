from django.urls import path, include
from rest_framework.routers import DefaultRouter
from . import views

from .controllers.envios import enviosCRUD
from .controllers.estadosenvios import estadosenviosCRUD
from .controllers.tecnicos import tecnicosCRUD
from .controllers.ventas import ventasCRUD

router = DefaultRouter()
router.register(r'envios', enviosCRUD)
router.register(r'estadoenvios', estadosenviosCRUD)
router.register(r'tecnicos', tecnicosCRUD)
router.register(r'ventas', ventasCRUD)

urlpatterns=[
    path('', views.home, name='home'),
    path('create/', views.createEnvioView, name='createEnvio'),
    path('eliminarEnvio/<idEnvio>', views.eliminarEnvio, name='eliminarEnvio'),
    path('api/', include(router.urls)),
]
