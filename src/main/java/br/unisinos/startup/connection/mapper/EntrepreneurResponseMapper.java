package br.unisinos.startup.connection.mapper;

import br.unisinos.startup.connection.controller.response.EntrepreneurResponseModel;
import br.unisinos.startup.connection.model.EntrepreneurModel;

import java.util.Optional;

public class EntrepreneurResponseMapper {
    public static EntrepreneurResponseModel mapFrom(EntrepreneurModel entrepreneurModel) {
        return Optional.ofNullable(entrepreneurModel).map(entrepreneur ->
                EntrepreneurResponseModel.builder()
                        .id(entrepreneur.getId())
                        .name(entrepreneur.getName())
                        .age(entrepreneur.getAge())
                        .city(entrepreneur.getCity())
                        .mail(entrepreneur.getMail())
                        .build()
                ).orElse(null);
    }
}