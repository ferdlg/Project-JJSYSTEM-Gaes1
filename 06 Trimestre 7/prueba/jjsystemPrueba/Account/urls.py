from django.urls import path
from . import views
from django.contrib.auth import views as auth_views

urlpatterns = [
    path('login/', views.userLogin, name='login'),
    path('register/', views.registerView, name='register'),
    path('logout/', views.logoutView, name='logout'),
    path('reestablecer_contraseña/', views.password_reset_form, name='password_reset_form'),
    path('reestablecer_contraseña_enviar/', auth_views.PasswordResetDoneView.as_view(template_name='password_reset_done.html'), name= 'password_reset_done'),
    path('reestablecer/<uidb64>/<token>/', views.password_reset_confirm, name = 'password_reset_confirm'),
    path('reestablecer_contraseña_completo/',auth_views.PasswordResetCompleteView.as_view(), name='password_reset_complete')
]