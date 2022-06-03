package br.unisinos.startup.connection.controller;

import br.unisinos.startup.connection.controller.response.ProjectResponseModel;
import br.unisinos.startup.connection.mapper.ProjectResponseMapper;
import br.unisinos.startup.connection.model.ProjectModel;
import br.unisinos.startup.connection.service.ProjectService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@AllArgsConstructor
@RestController
@RequestMapping("/v1/project")
public class ProjectController {
    
    private ProjectService projectService;

    @PostMapping(path = "/add", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.CREATED)
    public ProjectResponseModel addProject(@RequestBody ProjectModel project) {
        log.info("Controller - Salvando project {}", project);
        return ProjectResponseMapper.mapFrom(project);
    }

    @GetMapping(path = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public ProjectResponseModel findProjectById(@PathVariable Long id) {
        log.info("Controller - Procurando projeto de id: {}", id);
        return ProjectResponseMapper.mapFrom(ProjectModel.builder().build());
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public List<ProjectResponseModel> findAllProjects() {
        log.info("Controller - Buscando todos projetos");
        return List.of(ProjectResponseMapper.mapFrom(ProjectModel.builder().build()));
    }

    @DeleteMapping(path = "/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteProjectById(@PathVariable String id) {
        projectService.deleteProjectById(id);
        log.info("Controller - Deletando projeto de id: {}", id);
    }

    @PutMapping(path = "/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ProjectResponseModel updateProject(@PathVariable Long id, @RequestBody ProjectModel projectModel) {
        log.info("Controller - Atualizando projeto de id: {} -> Novo objeto {}", id, projectModel);
        return ProjectResponseMapper.mapFrom(projectModel);
    }
}
