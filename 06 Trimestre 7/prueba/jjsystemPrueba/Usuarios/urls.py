from django.urls import path, include
from Autenticacion import login , register

path('register/', register, name='registrp')
path('login/', login.LoginView, name='Login')
