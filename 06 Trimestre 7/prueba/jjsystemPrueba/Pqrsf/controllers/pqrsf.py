from datetime import timezone
import datetime
from django.shortcuts import get_object_or_404, redirect, render
from rest_framework import viewsets
from Account.models import *
from .serializers import PqrsfSerializer

class pqrsfCRUD(viewsets.ModelViewSet):
    queryset = Pqrsf.objects.all()
    serializer_class = PqrsfSerializer

    def ir_a_pqrsf(self,request):
    # Obtener todas las PQRSF del usuario actual
        tipos_pqrsf = Tipospqrsf.objects.all()
    # Obtener los estados de PQRSF
        estados_pqrsf = Estadospqrsf.objects.all()
        numerodocumento = request.user.numerodocumento
        pqrsfs = Pqrsf.objects.filter(idcliente__numerodocumento=numerodocumento)
        return render(request, 'cliente/ver_pqrsf.html', {'pqrsfs': pqrsfs, 'tipos_pqrsf': tipos_pqrsf, 'estados_pqrsf': estados_pqrsf})

    def crear_pqrsf(self,request):
        if request.method == 'POST':
            numerodocumento = request.user.numerodocumento
            cliente = get_object_or_404(Clientes, numerodocumento=numerodocumento)
            idcliente = cliente.idcliente
            # Obtener los datos del POST
            fechapqrsf = request.POST.get('fechapqrsf') # O cualquier método para obtener la fecha actual
            informacionpqrsf = request.POST.get('informacionpqrsf')
            idtipopqrsf = request.POST.get('idtipopqrsf')
            idestadopqrsf = request.POST.get('idestadopqrsf')

            # Crear la nueva PQRSF
            pqrsf = Pqrsf.objects.create(
                fechapqrsf=fechapqrsf,
                informacionpqrsf=informacionpqrsf,
                idtipopqrsf=idtipopqrsf,
                idestadopqrsf=idestadopqrsf,
                idcliente=cliente
            )
        
        return redirect('ir_a_pqrsf')
