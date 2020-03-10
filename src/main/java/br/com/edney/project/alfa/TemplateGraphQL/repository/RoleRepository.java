package br.com.edney.project.alfa.TemplateGraphQL.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import br.com.edney.project.alfa.TemplateGraphQL.model.Role;

public interface RoleRepository extends MongoRepository<Role, Long>{
    Role findByName(String name);

    @Override
    void delete(Role role);
}
