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

#urls back 

router = DefaultRouter()
router.register(r'actividades_cronograma', actividadesCrogTecCRUD)
router.register(r'citas',citasCRUD)
router.register(r'cotizaciones', cotizacionesCRUD)
router.register(r'cronograma_tecnicos', cronogramatecnicosCRUD)
router.register(r'detalles_actividades',detallesactividadesCRUD)
router.register(r'disponibilidad_cronograma', disponibilidadcronogramaCRUD)
router.register(r'estado_cotizaciones',estadocotizacionesCRUD)
router.register(r'tecnicos', tecnicosCRUD)


# urls front 
from .views import index

urlpatterns=[
    path('',include(router.urls)),
    path('index/', index , name='index'),
    path('cita_analisis/', citasCRUD.as_view({'get':'cita_analisis'}), name='cita_analisis'),
    path('cita_instalacion/', citasCRUD.as_view({'get':'cita_instalacion'}), name='cita_instalacion'),
    path('cita_mantenimiento/', citasCRUD.as_view({'get':'cita_mantenimiento'}), name='cita_mantenimiento'),
    path('crear_citas/', citasCRUD.as_view({'post':'crear_citas'}), name='crear_citas'),
    path('editar_citas/', citasCRUD.as_view({'put': 'editar_cita'}), name='editar_citas')
]
