package br.unisinos.startup.connection.controller;

import br.unisinos.startup.connection.controller.response.EntrepreneurResponseModel;
import br.unisinos.startup.connection.mapper.EntrepreneurResponseMapper;
import br.unisinos.startup.connection.model.EntrepreneurModel;
import br.unisinos.startup.connection.service.EntrepreneurService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@AllArgsConstructor
@RestController
@RequestMapping("/v1/entrepreneurs")
@CrossOrigin(origins = "http://localhost:3000", allowCredentials = "true")
public class EntrepreneurController {

    private EntrepreneurService entrepreneurService;

    @PostMapping(path = "/add", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.CREATED)
    public EntrepreneurResponseModel addEntrepreneurs(@RequestBody EntrepreneurModel entrepreneur) {
        log.info("Controller - Salvando entrepreneur {}", entrepreneur);
        return EntrepreneurResponseMapper.mapFrom(entrepreneurService.saveEntrepreneurs(entrepreneur));
    }

    @GetMapping(path = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public EntrepreneurResponseModel findEntrepreneurById(@PathVariable String id) {
        log.info("Controller - Procurando entrepeneur de id: {}", id);
        return EntrepreneurResponseMapper.mapFrom(entrepreneurService.findEntrepreneurById(id));
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public List<EntrepreneurResponseModel> findAllEntrepreneurs() {
        log.info("Controller - Buscando todos entrepeneurs");
        return EntrepreneurResponseMapper.mapListFrom(entrepreneurService.findAllEntrepreneurs());
    }

    @DeleteMapping(path = "/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteEntrepreneurById(@PathVariable String id) {
        entrepreneurService.deleteEntrepreneurById(id);
        log.info("Controller - Deletando entrepeneur de id: {}", id);
    }

    @PutMapping(path = "/{id}")
    @ResponseStatus(HttpStatus.OK)
    public EntrepreneurResponseModel updateEntrepreneur(@PathVariable String id, @RequestBody EntrepreneurModel entrepreneurModel) {
        log.info("Controller - Atualizando entrepeneur de id: {} -> Novo objeto {}", id, entrepreneurModel);
        return EntrepreneurResponseMapper.mapFrom(entrepreneurService.updateEntrepreneur(id, entrepreneurModel));
    }
}