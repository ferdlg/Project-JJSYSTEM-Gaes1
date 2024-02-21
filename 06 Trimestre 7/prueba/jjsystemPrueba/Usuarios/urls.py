from django.urls import path, include
from .Autenticacion import login , register

path('register/', register, name='registro')
path('login/', login, name='Login')
