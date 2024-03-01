from rest_framework import serializers
from ..models import *

class UsuariosSerializers(serializers.ModelSerializer):
    class Meta:
        model = Usuarios
        fields = '__all__'

class CategoriasSerializers(serializers.ModelSerializer):
    class Meta:
        model = CategoriaLibros
        fields= '__all__'

class EstadosSerializers(serializers.ModelSerializer):
    class Meta:
        model = EstadoLibros
        fields= '__all__'

class LibroUsuarioSerializers(serializers.ModelSerializer):
    class Meta:
        model = LibroUsuario
        fields= '__all__'

class LibrosSerializers(serializers.ModelSerializer):
    class Meta:
        model = Libros
        fields= '__all__'

