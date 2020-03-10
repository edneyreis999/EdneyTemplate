package br.com.edney.project.alfa.TemplateGraphQL.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import br.com.edney.project.alfa.TemplateGraphQL.model.Privilege;

public interface PrivilegeRepository extends MongoRepository<Privilege, String>{
    Privilege findByName(String name);

    @Override
    void delete(Privilege privilege);
}
