package br.unisinos.startup.connection.service;

import br.unisinos.startup.connection.exception.ProjectNotFoundException;
import br.unisinos.startup.connection.model.ProjectModel;
import br.unisinos.startup.connection.repository.ProjectRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Slf4j
@AllArgsConstructor
@Service
public class ProjectService {

    private ProjectRepository repository;

    public ProjectModel saveProject(ProjectModel project) {
        try {
            repository.save(project);
        } catch (Exception e) {
            log.warn("Service - Project {} não salvo. Motivo: ", project, e);
        }
        log.info("Service - Project salvo {} no banco", project);

        return project;
    }

    public ProjectModel findProjectById(String id) {
        log.info("Service - Procurando Project de id: {}", id);
        return repository.findById(id).orElseThrow(() -> new ProjectNotFoundException(id));
    }

    public List<ProjectModel> findAllProjects() {
        log.info("Service - Buscando todos Projects");

        return repository.findAll();
    }

    public void deleteProjectById(String id) {

        repository.delete(findProjectById(id));
        log.info("Service - Deletado Project de id: {}", id);
    }

    public ProjectModel updateProject(String id, ProjectModel projectModel) {
        var projectRepository = findProjectById(id);

        if (Objects.equals(projectRepository, projectModel))
            return projectModel;

        log.info("Service - Atualizado Project {} -> Novo objeto {}", projectRepository, projectModel);
        return projectModel;
    }
}