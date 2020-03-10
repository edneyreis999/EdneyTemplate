package br.com.edney.project.alfa.TemplateGraphQL.repository;

import java.util.List;

import org.javers.spring.annotation.JaversSpringDataAuditable;
import org.springframework.data.mongodb.repository.MongoRepository;

import br.com.edney.project.alfa.TemplateGraphQL.model.User;

@JaversSpringDataAuditable
public interface UserRepository extends MongoRepository<User, String>{
	User findByEmail(final String email);
}