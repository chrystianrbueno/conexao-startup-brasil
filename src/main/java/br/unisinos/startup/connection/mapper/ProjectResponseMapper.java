package br.unisinos.startup.connection.mapper;

import br.unisinos.startup.connection.controller.response.ProjectResponseModel;
import br.unisinos.startup.connection.model.ProjectModel;

import java.util.Optional;

public class ProjectResponseMapper {
    public static ProjectResponseModel mapFrom(ProjectModel project) {
        return Optional.ofNullable(project).map(projectModel ->
                ProjectResponseModel.builder()
                        .name(project.getName())
                        .status(project.getStatus())
                        .description(project.getDescription())
                        .build()
        ).orElse(null);
    }

}