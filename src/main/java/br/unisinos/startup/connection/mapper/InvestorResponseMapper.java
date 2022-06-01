package br.unisinos.startup.connection.mapper;

import br.unisinos.startup.connection.controller.response.EntrepreneurResponseModel;
import br.unisinos.startup.connection.controller.response.InvestorResponseModel;
import br.unisinos.startup.connection.model.EntrepreneurModel;
import br.unisinos.startup.connection.model.InvestorModel;

import java.util.Optional;

public class InvestorResponseMapper {
    public static InvestorResponseModel mapFrom(InvestorModel investorResponseModel) {
        return Optional.ofNullable(investorResponseModel).map(investor ->
                InvestorResponseModel.builder()
                        .id(investor.getId())
                        .name(investor.getName())
                        .age(investor.getAge())
                        .city(investor.getCity())
                        .mail(investor.getMail())
                        .build()
        ).orElse(null);
    }
}