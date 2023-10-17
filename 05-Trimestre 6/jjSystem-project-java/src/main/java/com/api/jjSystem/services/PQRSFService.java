package com.api.jjSystem.services;

import com.api.jjSystem.Repository.PQRSFRepository;
import com.api.jjSystem.models.PQRSF;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class PQRSFService {

    @Autowired
    private PQRSFRepository pqrsfRepository;

    public PQRSF createPQRSF (PQRSF pqrsf)
    {
        return pqrsfRepository.save(pqrsf);
    }

    public  PQRSF getPQRSFById (Integer id)
    {
        Optional<PQRSF> optionalPQRSF = pqrsfRepository.findById(id);
        return optionalPQRSF.get();
    }

    public List<PQRSF> getAllPQRSF()
    {
        return pqrsfRepository.findAll();
    }

    public void deletePQRSF (Integer id)
    {
        pqrsfRepository.deleteById(id);
    }
}
