package br.unisinos.startup.connection.service;

import br.unisinos.startup.connection.exception.InvestorNotFoundException;
import br.unisinos.startup.connection.model.InvestorModel;
import br.unisinos.startup.connection.repository.InvestorRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Slf4j
@AllArgsConstructor
@Service
public class InvestorService {

    private InvestorRepository repository;

    public InvestorModel saveInvestors(InvestorModel investor) {
        try {
            repository.save(investor);
        } catch (Exception e) {
            log.warn("Service - Investor {} não salvo. Motivo: ", investor, e);
        }
        log.info("Service - Investor salvo {} no banco", investor);

        return investor;
    }

    public InvestorModel findInvestorById(String id) {
        log.info("Service - Procurando Investor de id: {}", id);
        return repository.findById(id).orElseThrow(() -> new InvestorNotFoundException(id));
    }

    public List<InvestorModel> findAllInvestors() {
        log.info("Service - Buscando todos Investors");

        return repository.findAll();
    }

    public void deleteInvestorById(String id) {

        repository.delete(findInvestorById(id));
        log.info("Service - Deletado Investor de id: {}", id);
    }

    public InvestorModel updateInvestor(String id, InvestorModel investorModel) {
        var investorRepository = findInvestorById(id);

        if (Objects.equals(investorRepository, investorModel))
            return investorModel;

        log.info("Service - Atualizado investor {} -> Novo objeto {}", investorRepository, investorModel);
        return investorModel;
    }
}