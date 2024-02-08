from django.urls import path, include
from rest_framework.routers import DefaultRouter

from .controllers.estadospqrsf import estadospqrsfCRUD
from .controllers.tipospqrsf import tipospqrsfCRUD
from .controllers.pqrsf import pqrsfCRUD

router = DefaultRouter()
router.register(r'Estadospqrsf', estadospqrsfCRUD)
router.register(r'Tipospqrsf', tipospqrsfCRUD)
router.register(r'Pqrsf', pqrsfCRUD)

urlpatterns=[
    path('',include(router.urls)),
]