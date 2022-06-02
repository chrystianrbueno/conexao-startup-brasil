package br.unisinos.startup.connection.repository;


import br.unisinos.startup.connection.model.ProjectModel;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ProjectRepository extends MongoRepository<ProjectModel, String> {
}
