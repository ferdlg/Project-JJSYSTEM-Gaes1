import os
from unittest import TestCase
import django
import pytest

os.environ.setdefault('DJANGO_SETTINGS_MODULE', 'jjsystemPrueba.settings')
django.setup()

from ..models import Servicios, Categoriasservicios

class TestServicio(TestCase):

    def setUp(self):
        categoria = Categoriasservicios.objects.get(idcategoriaservicio = 1)
        self.servicio = Servicios.objects.create(
            nombreservicio='prueba',
            descripcionservicio='prueba test',
            idcategoriaservicio= categoria
        )

    def test_servicio_crear(self):
        servicio = Servicios.objects.get(idservicio=self.servicio.idservicio)
        self.assertEqual(servicio.nombreservicio, 'prueba')
        self.assertEqual(servicio.descripcionservicio, 'prueba test')
