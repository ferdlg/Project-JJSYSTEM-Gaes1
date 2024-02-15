from rest_framework.views import APIView
from rest_framework.response import Response
from rest_framework import status
from django.contrib.auth import authenticate, login , logout

class LoginView(APIView):
    def post(self, request):
        email = request.data.get('email')
        password = request.data.get('password')
        user = authenticate(email= email, password = password)
        if user is not None:
            login(request, user)
            return Response({
                'message':'Inicio de sesion exitoso'
            }, status=status.HTTP_200_OK)
        else:
            return Response({
                'message':'Email o contraseña incorrectos'
            }, status= status.HTTP_401_UNAUTHORIZED)

# Create your views here.
