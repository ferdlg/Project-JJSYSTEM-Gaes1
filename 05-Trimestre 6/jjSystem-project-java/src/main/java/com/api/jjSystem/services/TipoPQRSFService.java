package com.api.jjSystem.services;

import com.api.jjSystem.Repository.TipoPQRSFRepository;
import com.api.jjSystem.models.TipoPQRSF;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class TipoPQRSFService {

    @Autowired
    private TipoPQRSFRepository tipoPQRSFRepository;

    public TipoPQRSF createTipo (TipoPQRSF tipoPQRSF)
    {
        return tipoPQRSFRepository.save(tipoPQRSF);
    }

    public TipoPQRSF getTipoById (Integer id)
    {
        Optional<TipoPQRSF> optionalTipoPQRSF = tipoPQRSFRepository.findById(id);
        return optionalTipoPQRSF.get();
    }

    public List<TipoPQRSF> getAllTipos ()
    {
        return tipoPQRSFRepository.findAll();
    }

    public void deleteTipo (Integer id)
    {
        tipoPQRSFRepository.deleteById(id);
    }
}
