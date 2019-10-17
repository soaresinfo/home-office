package com.br.everis.homeoffice.model.service;

import com.br.everis.homeoffice.model.entity.Center;
import com.br.everis.homeoffice.model.repository.CenterRepository;
import com.br.everis.homeoffice.model.service.ServiceFacade.ICenterServiceFacade;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author Marcelo
 */
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
@Service
public class CenterServiceImpl extends BaseService implements ICenterServiceFacade {

    @Autowired
    private final CenterRepository repository;

    @Override
    public List<Center> findAll() {
        return this.repository.findAll();
    }

    @Transactional
    @Override
    public Center save(Center center) {
        return repository.save(center);

    }

}
