package com.api.jjSystem.services;

import com.api.jjSystem.Repository.CronogramaTecnicosRepository;
import com.api.jjSystem.models.CronogramaTecnicos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class CronogramaTecnicosService {
    @Autowired
    private CronogramaTecnicosRepository cronogramaTecnicosRepository;
    public CronogramaTecnicos createCronograma(CronogramaTecnicos cronogramaTecnicos)
    {
        return cronogramaTecnicosRepository.save(cronogramaTecnicos);
    }
    public CronogramaTecnicos getCronogramaById(Integer idCronogramaTecnicos)
    {
        Optional<CronogramaTecnicosRepository> cronogramaTecnicos = cronogramaTecnicosRepository.findById(idCronogramaTecnicos);
        return cronogramaTecnicos.get();
    }
    public List<CronogramaTecnicos> getAllCronogramas()
    {
        return cronogramaTecnicosRepository.findAll();
    }
    public void deleteCronogramaById(Integer idCronogramaTecnico)
    {
        cronogramaTecnicosRepository.deleteById(idCronogramaTecnico);
    }
}
