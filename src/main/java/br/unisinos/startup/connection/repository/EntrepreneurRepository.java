package br.unisinos.startup.connection.repository;

import br.unisinos.startup.connection.model.EntrepreneurModel;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface EntrepreneurRepository extends MongoRepository<EntrepreneurModel, String> {}