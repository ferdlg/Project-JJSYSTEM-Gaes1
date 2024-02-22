from django.urls import path, include
from rest_framework.routers import DefaultRouter
from . import views

from .controllers.estadospqrsf import estadospqrsfCRUD
from .controllers.tipospqrsf import tipospqrsfCRUD
from .controllers.pqrsf import pqrsfCRUD

router = DefaultRouter()
router.register(r'Estadospqrsf', estadospqrsfCRUD)
router.register(r'Tipospqrsf', tipospqrsfCRUD)
router.register(r'Pqrsf', pqrsfCRUD)

urlpatterns=[
    path('', views.home, name='homePqrsf'),
    path('',include(router.urls)),
    path('edit/', views.edit, name='edit'),
    path('index/', views.index, name='index'),
    path('create/', views.createPqrsfView, name='createPqrsf'),
    path('editarPqrsf/<idPQSRF>', views.editarPqrsf, name='editarPqrsf'),
    path('eliminarPqrsf/<idPQRSF>', views.eliminarPqrsf, name='eliminarPqrsf'),
]