from rest_framework import serializers
from ..models import *

#creamos una clase serializers para cada tabla
class RolesSerializers(serializers.ModelSerializer):
    #incluimos la clase Meta, para que le de instrucciones al serializador
    class Meta:
    #le indicamos el modelo que debe buscar
        model = Roles
    #le especificamos los campos que debe serializar
        fields = '__all__'

'''
Nota: en tablas en las que debemos traer opciones,
se deben especificar uno por uno los campos a serializar
'''

class UsuariosSerializers(serializers.ModelSerializer):
    class Meta:
        model = Usuarios
        fields = '__all__'


class ClientesSerializers(serializers.ModelSerializer):
    class Meta:
        model = Clientes
        fields = '__all__'

class CategoriasProductosSerializers(serializers.Serializer):
    class Meta:
        model = Categoriasproductos
        fields = '__all__'

class CategoriasServiciosSerializers(serializers.Serializer):
    class Meta:
        model = Categoriasservicios
        fields = '__all__'

class ProductosSerializer(serializers.Serializer):
    class Meta: 
        model = Productos
        fields = '__all__'

class ServiciosSerializer(serializers.Serializer):
    class Meta:
        model = Servicios
        fields = '__all__'

class ProveedoresProductosSerializer(serializers.Serializer):
    class Meta:
        model = Proveedoresproductos
        fields = '__all__'
    
