package com.api.jjSystem.services;

import com.api.jjSystem.Repository.TiposPQRSFRepository;
import com.api.jjSystem.models.TiposPQRSF;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class TiposPQRSFService {

    @Autowired
    private TiposPQRSFRepository tiposPQRSFRepository;

    public TiposPQRSF createTipoPQRSF(TiposPQRSF tipoPQRSF)
    {
        return tiposPQRSFRepository.save(tipoPQRSF);
    }

    public TiposPQRSF getTipoPQRSFById(Integer idTiposPQRSF)
    {
        Optional<TiposPQRSF> optionalTiposPQRSF = tiposPQRSFRepository.findById(idTiposPQRSF);
        return optionalTiposPQRSF.get();
    }

    public List<TiposPQRSF> getAllTiposPQRSF()
    {
        return tiposPQRSFRepository.findAll();
    }

    public void deleteTiposPQRSF(Integer idTipoPQRSF)
    {
        tiposPQRSFRepository.deleteById(idTipoPQRSF);
    }

}
