package br.unisinos.startup.connection.mapper;

import br.unisinos.startup.connection.controller.response.EntrepreneurResponseModel;
import br.unisinos.startup.connection.model.EntrepreneurModel;

import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

public class EntrepreneurResponseMapper {
    public static EntrepreneurResponseModel mapFrom(EntrepreneurModel entrepreneurModel) {
        return Optional.ofNullable(entrepreneurModel).map(entrepreneur ->
                EntrepreneurResponseModel.builder()
                        .id(entrepreneur.getId())
                        .name(entrepreneur.getName())
                        .username(entrepreneur.getUsername())
                        .age(entrepreneur.getAge())
                        .city(entrepreneur.getCity())
                        .mail(entrepreneur.getMail())
                        .build()
                ).orElse(null);
    }

    public static List<EntrepreneurResponseModel> mapListFrom(List<EntrepreneurModel> listEntrepreneurs) {
        if (Objects.isNull(listEntrepreneurs))
            return Collections.emptyList();
        return listEntrepreneurs.stream().map(EntrepreneurResponseMapper::mapFrom).collect(Collectors.toList());
    }
}