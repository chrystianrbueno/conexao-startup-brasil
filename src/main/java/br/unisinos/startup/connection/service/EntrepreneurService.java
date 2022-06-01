package br.unisinos.startup.connection.service;

import br.unisinos.startup.connection.exception.EntrepreneurNotFound;
import br.unisinos.startup.connection.model.EntrepreneurModel;
import br.unisinos.startup.connection.repository.EntrepreneurRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Slf4j
@AllArgsConstructor
@Service
public class EntrepreneurService {

    private EntrepreneurRepository repository;

    public EntrepreneurModel saveEntrepreneurs(EntrepreneurModel entrepreneur) {
        try {
            repository.save(entrepreneur);
        } catch (Exception e) {
            log.warn("Service - Entrepreneur {} não salvo. Motivo: ", entrepreneur, e);
        }

        log.info("Service - Entrepreneur salvo {} no banco", entrepreneur);

        return entrepreneur;
    }

    public EntrepreneurModel findEntrepreneurById(String id) {
        log.info("Service - Procurando entrepeneur de id: {}", id);
        return repository.findById(id).orElseThrow(() -> new EntrepreneurNotFound(id));
    }

    public List<EntrepreneurModel> findAllEntrepreneurs() {
        log.info("Service - Buscando todos entrepeneurs");

        return repository.findAll();
    }

    public void deleteEntrepreneurById(String id) {
        try {
            repository.deleteById(id);
        } catch (Exception e) {
            log.warn("Service - Entrepreneur de {} não deletado. Motivo: ", id, e);
        }

        log.info("Service - Deletado entrepeneur de id: {}", id);
    }

    public EntrepreneurModel updateEntrepreneur(String id, EntrepreneurModel entrepreneurModel) {
        var entrepreneurRepository = findEntrepreneurById(id);

        if (Objects.equals(entrepreneurRepository,entrepreneurModel))
            return entrepreneurModel;

        log.info("Service - Atualizado entrepeneur {} -> Novo objeto {}", entrepreneurRepository, entrepreneurModel);
        return entrepreneurModel;
    }
}