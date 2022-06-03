package br.unisinos.startup.connection.controller;

import br.unisinos.startup.connection.controller.response.InvestorResponseModel;
import br.unisinos.startup.connection.mapper.InvestorResponseMapper;
import br.unisinos.startup.connection.model.InvestorModel;
import br.unisinos.startup.connection.service.InvestorService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@AllArgsConstructor
@RestController
@RequestMapping("/v1/investor")
public class InvestorController {
    
    private InvestorService investorService;

    @PostMapping(path = "/add", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.CREATED)
    public InvestorResponseModel addInvestor(@RequestBody InvestorModel investor) {
        log.info("Controller - Salvando investor {}", investor);
        return InvestorResponseMapper.mapFrom(investor);
    }

    @GetMapping(path = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public InvestorResponseModel findInvestorById(@PathVariable Long id) {
        log.info("Controller - Procurando investidor de id: {}", id);
        return InvestorResponseMapper.mapFrom(InvestorModel.builder().build());
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public List<InvestorResponseModel> findAllInvestors() {
        log.info("Controller - Buscando todos investidores");
        return List.of(InvestorResponseMapper.mapFrom(InvestorModel.builder().build()));
    }

    @DeleteMapping(path = "/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteInvestorById(@PathVariable String id) {
        investorService.deleteInvestorById(id);
        log.info("Controller - Deletando investidor de id: {}", id);
    }

    @PutMapping(path = "/{id}")
    @ResponseStatus(HttpStatus.OK)
    public InvestorResponseModel updateInvestor(@PathVariable Long id, @RequestBody InvestorModel investorModel) {
        log.info("Controller - Atualizando investidor de id: {} -> Novo objeto {}", id, investorModel);
        return InvestorResponseMapper.mapFrom(investorModel);
    }
}
