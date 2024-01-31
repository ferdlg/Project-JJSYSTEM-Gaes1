from rest_framework import serializers
from ..models import *

class TecnicosSerializer(serializers.Serializer):
    class Meta:
        model = Tecnicos
        fields = '__all__'

class CitasSerializer(serializers.Serializer):
    class Meta:
        model = Citas
        fields = '__all__'

class CotizacionesSerializer(serializers.Serializer):
    class Meta:
        model = Cotizaciones
        fields = '__all__'

class CronogramatecnicosSerializer(serializers.Serializer):
    class Meta:
        model = Cronogramatecnicos
        fields = '__all__'

class ActividadescronogramatecnicosSerializer(serializers.Serializer):
    class Meta:
        model = Actividadescronogramatecnicos
        fields = '__all__'

class DetallesactividadcronogramaSerializer(serializers.Serializer):
    class Meta:
        model = Detallesactividadcronograma
        fields = '__all__'

class DisponibilidadcronogramasSerializer(serializers.Serializer):
    class Meta:
        model = Disponibilidadcronogramas
        fields = '__all__'


class EstadoscotizacionesSerializer(serializers.Serializer):
    class Meta:
        model = Estadoscotizaciones
        fields = '__all__'


