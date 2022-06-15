package br.unisinos.startup.connection.mapper;

import br.unisinos.startup.connection.controller.response.ProjectResponseModel;
import br.unisinos.startup.connection.model.ProjectModel;

import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

public class ProjectResponseMapper {
    public static ProjectResponseModel mapFrom(ProjectModel project) {
        return Optional.ofNullable(project).map(projectModel ->
                ProjectResponseModel.builder()
                        .id(project.getId())
                        .name(project.getName())
                        .status(project.getStatus())
                        .description(project.getDescription())
                        .build()
        ).orElse(null);
    }

    public static List<ProjectResponseModel> mapListFrom(List<ProjectModel> listProjects) {
        if (Objects.isNull(listProjects))
            return Collections.emptyList();
        return listProjects.stream().map(ProjectResponseMapper::mapFrom).collect(Collectors.toList());
    }

}