from django import forms
from .models import Usuarios
from .models import Roles
from .models import Estadosusuarios

class LoginForm(forms.Form):
    email = forms.CharField(widget=forms.TextInput(attrs={'class': 'form-control'}))
    password = forms.CharField(widget=forms.PasswordInput(attrs={'class': 'form-control'}))

class RegisterForm(forms.ModelForm):
    numerodocumento = forms.IntegerField(label='Numero de documento', widget=forms.NumberInput(attrs={'class': 'form-control border-0', 'required': True}))
    nombre = forms.CharField(label='Nombre', widget=forms.TextInput(attrs={'class': 'form-control', 'required': True}))
    apellido = forms.CharField(label='Apellido', widget=forms.TextInput(attrs={'class': 'form-control', 'required': True}))
    email = forms.EmailField(label='Email', widget=forms.EmailInput(attrs={'class': 'form-control', 'required': True}))
    password = forms.CharField(label='Contraseña', widget=forms.PasswordInput(attrs={'class': 'form-control', 'required': True}))
    numerocontacto = forms.IntegerField(label='Numero de contacto', widget=forms.NumberInput(attrs={'class': 'form-control', 'required': True}))

    class Meta:
        model = Usuarios
        exclude = ['idrol', 'idestadosusuarios', 'last_login']