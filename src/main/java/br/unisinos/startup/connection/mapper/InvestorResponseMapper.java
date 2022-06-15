package br.unisinos.startup.connection.mapper;

import br.unisinos.startup.connection.controller.response.InvestorResponseModel;
import br.unisinos.startup.connection.model.InvestorModel;

import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

public class InvestorResponseMapper {
    public static InvestorResponseModel mapFrom(InvestorModel investorResponseModel) {
        return Optional.ofNullable(investorResponseModel).map(investor ->
                InvestorResponseModel.builder()
                        .id(investor.getId())
                        .username(investor.getUsername())
                        .name(investor.getName())
                        .age(investor.getAge())
                        .city(investor.getCity())
                        .mail(investor.getMail())
                        .build()
        ).orElse(null);
    }

    public static List<InvestorResponseModel> mapListFrom(List<InvestorModel> listInvestors) {
        if (Objects.isNull(listInvestors))
            return Collections.emptyList();
        return listInvestors.stream().map(InvestorResponseMapper::mapFrom).collect(Collectors.toList());
    }
}
