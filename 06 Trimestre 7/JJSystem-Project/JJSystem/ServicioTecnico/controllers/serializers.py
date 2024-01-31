from rest_framework import serializers
from ..models import *

class TecnicosSerializer(serializers.ModelSerializer):
    class Meta:
        model = Tecnicos
        fields = '__all__'

class CitasSerializer(serializers.ModelSerializer):
    class Meta:
        model = Citas
        fields = '__all__'

class CotizacionesSerializer(serializers.ModelSerializer):
    class Meta:
        model = Cotizaciones
        fields = '__all__'

class CronogramatecnicosSerializer(serializers.ModelSerializer):
    class Meta:
        model = Cronogramatecnicos
        fields = '__all__'

class ActividadescronogramatecnicosSerializer(serializers.ModelSerializer):
    class Meta:
        model = Actividadescronogramatecnicos
        fields = '__all__'

class DetallesactividadcronogramaSerializer(serializers.ModelSerializer):
    class Meta:
        model = Detallesactividadcronograma
        fields = '__all__'

class DisponibilidadcronogramasSerializer(serializers.ModelSerializer):
    class Meta:
        model = Disponibilidadcronogramas
        fields = '__all__'


class EstadoscotizacionesSerializer(serializers.ModelSerializer):
    class Meta:
        model = Estadoscotizaciones
        fields = '__all__'


