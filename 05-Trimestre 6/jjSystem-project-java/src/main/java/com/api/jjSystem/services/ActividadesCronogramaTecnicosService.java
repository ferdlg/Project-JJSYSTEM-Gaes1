package com.api.jjSystem.services;

import com.api.jjSystem.Repository.ActividadesCronogramaTecnicosRepository;
import com.api.jjSystem.models.ActividadesCronogramaTecnicos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class ActividadesCronogramaTecnicosService {
    @Autowired
    private ActividadesCronogramaTecnicosRepository actividadesCronogramaTecnicosRepository;

    public ActividadesCronogramaTecnicos createActividadesTecnicos(ActividadesCronogramaTecnicos actividadesCronogramaTecnicos)
    {
        return actividadesCronogramaTecnicosRepository.save(actividadesCronogramaTecnicos);
    }
    public ActividadesCronogramaTecnicos getActidadesTecnicosById(Integer idActividadCronogramaTecnico)
    {
        Optional<ActividadesCronogramaTecnicos> actividadesCronogramaTecnicos= actividadesCronogramaTecnicosRepository.findById(idActividadCronogramaTecnico);
        return actividadesCronogramaTecnicos.get();
    }
    public List<ActividadesCronogramaTecnicos> getAllActidadesTecnicos()
    {
        return actividadesCronogramaTecnicosRepository.findAll();
    }
    public void deleteActidadesTecnicos(Integer idActividadCronogramaTecnico)
    {
        actividadesCronogramaTecnicosRepository.deleteById(idActividadCronogramaTecnico);
    }
}
