package br.unisinos.startup.connection.controller;

import br.unisinos.startup.connection.model.EntrepreneurModel;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/v1/entrepreneurs")
public class EntrepreneurController {

    @PostMapping(path = "/add", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.CREATED)
    public EntrepreneurModel addEntrepreneurs(@RequestBody EntrepreneurModel entrepreneur) {
        log.info("{}", entrepreneur);
        return entrepreneur;
    }

    @GetMapping(path = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public EntrepreneurModel findEntrepreneurById(@PathVariable Long id) {
        log.info("Procurando entrepeneur de id: {}", id);
        return EntrepreneurModel.builder().build();
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public List<EntrepreneurModel> findAllEntrepreneurs() {
        log.info("Buscando todos entrepeneurs");
        return List.of(EntrepreneurModel.builder().build());
    }

    @DeleteMapping(path = "/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteEntrepreneurById(@PathVariable Long id) {
        log.info("Deletando entrepeneur de id: {}", id);
    }

    @PutMapping(path = "/{id}")
    @ResponseStatus(HttpStatus.OK)
    public EntrepreneurModel updateEntrepreneur(@PathVariable Long id, @RequestBody EntrepreneurModel entrepreneurModel) {
        log.info("Atualizando entrepeneur de id: {} -> Novo objeto {}", id, entrepreneurModel);
        return entrepreneurModel;
    }
}