from rest_framework.response import Response
from rest_framework import viewsets, status
from django.shortcuts import render, redirect
from ..models import Tecnicos
from .serializers import TecnicosSerializer
from django.core.paginator import Paginator , EmptyPage , PageNotAnInteger


class tecnicosCRUD(viewsets.ModelViewSet):
    queryset = Tecnicos.objects.all()
    serializer_class = TecnicosSerializer

    @classmethod
    def listar_tecnicos(cls, request):
        tecnicos_list = cls.queryset

        paginator = Paginator(tecnicos_list, 5)  # Mostrar 10 productos por página
        page_number = request.GET.get('page')      # Obtener el número de página solicitado
        try:
            tecnico = paginator.page(page_number)
        except PageNotAnInteger:
            tecnico = paginator.page(1)
        except EmptyPage:
            tecnico = paginator.page(paginator.num_pages)
        return render(request, 'vertecnicos.html', {'tecnicos': tecnico})
    
    #Mostrar listado de tecnicos
    #registrar tecnicos
    #actualizar datos de tecnicos
    #eliminar tecnicos