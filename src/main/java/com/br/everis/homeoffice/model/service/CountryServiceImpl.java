package com.br.everis.homeoffice.model.service;

import com.br.everis.homeoffice.model.entity.Country;
import com.br.everis.homeoffice.model.repository.CountryRepository;
import com.br.everis.homeoffice.model.service.ServiceFacade.ICountryServiceFacade;
import javassist.NotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

/**
 * @author alan.franco
 */
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
@Service
public class CountryServiceImpl extends BaseService implements ICountryServiceFacade {

    /**
     * Injetando as dependências da interface de abstração do spring data
     * responsável pelo acesso aos dados deste objeto
     */

    private static final String MSG_ERROR_NOT_FOUND = "Não foi encontrado um país para o id %d";

    @Autowired
    private final CountryRepository geradorRepository;

    @Override
    public List<Country> listAll() throws Exception {
        try {
            return this.geradorRepository.findAll();
        } catch (Exception e) {
            super.LOGGER.error("Ocorreu um erro na classe: CountryService >> listarTodos(): " + e.getMessage());
            throw new Exception(e.getMessage());
        }
    }

    @Override
    public Country findById(long id) throws NotFoundException {
        Optional<Country> result = this.geradorRepository.findById(id);
        if (result.isPresent()) {
            return result.get();
        } else {
            throw new NotFoundException(String.format(MSG_ERROR_NOT_FOUND, id));
        }
    }

    @Transactional
    @Override
    public Country save(Country country) {
        return this.geradorRepository.save(country);
    }

    @Transactional
    @Modifying
    @Override
    public Country update(Country country) {
        return this.geradorRepository.save(country);
    }

    @Transactional
    @Override
    public void delete(long id) throws Exception {
        this.geradorRepository.deleteById(id);
    }

}
