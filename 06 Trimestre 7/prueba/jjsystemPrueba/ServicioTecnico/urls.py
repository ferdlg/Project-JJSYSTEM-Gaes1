from django.urls import path, include
from rest_framework.routers import DefaultRouter

from .controllers.actividadesCrogTec import actividadesCrogTecCRUD
from .controllers.citas import citasCRUD
from .controllers.cotizaciones import cotizacionesCRUD
from .controllers.cronogramatecnicos import cronogramatecnicosCRUD
from .controllers.detallesactividades import detallesactividadesCRUD
from .controllers.disponibilidadcronograma import disponibilidadcronogramaCRUD
from .controllers.estadocotizaciones import estadocotizacionesCRUD
from .controllers.tecnicos import tecnicosCRUD

router = DefaultRouter()
router.register(r'actividades_cronograma', actividadesCrogTecCRUD)
router.register(r'citas',citasCRUD)
router.register(r'cotizaciones', cotizacionesCRUD)
router.register(r'cronograma_tecnicos', cronogramatecnicosCRUD)
router.register(r'detalles_actividades',detallesactividadesCRUD)
router.register(r'disponibilidad_cronograma', disponibilidadcronogramaCRUD)
router.register(r'estado_cotizaciones',estadocotizacionesCRUD)
router.register(r'tecnicos', tecnicosCRUD)

urlpatterns=[
    path('',include(router.urls)),
]
