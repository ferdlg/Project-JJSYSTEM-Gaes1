from django.urls import path
from . import views
from django.contrib.auth import views as auth_views

urlpatterns = [
    path('login/', views.userLogin, name='login'),
    path('register/', views.registerView, name='register'),
    path('logout/', views.logoutView, name='logout'),
    path('reestablecer_password_form/', views.password_reset_request, name='password_reset_request_form'),
    path('reestablecer_password/', views.PasswordResetRequestView.as_view(), name='password_reset_request'),
    path('reestablecer_password_confirmar/<uidb64>/<token>/', views.PasswordResetView.as_view(), name='password_reset_confirm'),
    
]