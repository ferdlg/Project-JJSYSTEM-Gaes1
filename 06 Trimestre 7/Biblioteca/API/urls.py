from django.urls import path, include
from rest_framework.routers import DefaultRouter

from .controllers.categoriasController import categoriasCRUD
from .controllers.estadosController import estadosCRUD
from .controllers.librosController import librosCRUD
from .controllers.libroUsuarioController import libroUsuarioCRUD
from .controllers.usuariosController import usuariosCRUD
from .views import registro, login


router = DefaultRouter()
router.register(r'categorias', categoriasCRUD)
router.register(r'estados', estadosCRUD)
router.register(r'libros', librosCRUD)
router.register(r'libro_usuario', libroUsuarioCRUD)
router.register(r'usuarios', usuariosCRUD)

urlpatterns= [
    path('', include(router.urls)),
    path('login/',login, name = 'login'),
    path('registro/', registro, name = 'registro')
]
