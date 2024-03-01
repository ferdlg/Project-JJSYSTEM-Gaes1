import pytest

from ..models import Servicios


class TestServicio():
    def __init__(self, nombreservicio,descripcionservicio,idcategoriaservicio):
        self.nombreservicio = nombreservicio
        self.descripcionservicio = descripcionservicio
        self.idcategoriaservicio = idcategoriaservicio
        

    def test_crear_servicio(self):
        servicio = Servicios(servicio.nombreservicio, servicio.descripcionservicio, servicio.idcategoriaservicio)
        nombreservicio = 'Mantenimiento',
        descripcionservicio = 'servicio mantenimiento',
        idcategoriaservicio = '1'

        assert servicio.nombreservicio == 'Mantenimiento'

