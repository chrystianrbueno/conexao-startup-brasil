package br.unisinos.startup.connection.repository;


import br.unisinos.startup.connection.model.InvestorModel;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface InvestorRepository extends MongoRepository<InvestorModel, String> {
}
