package br.com.edney.project.alfa.TemplateGraphQL.resolvers;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;

import br.com.edney.project.alfa.TemplateGraphQL.exception.user.UserNotFoundException;
import br.com.edney.project.alfa.TemplateGraphQL.model.User;
import br.com.edney.project.alfa.TemplateGraphQL.repository.UserRepository;

@Component
public class Query implements GraphQLQueryResolver {

	@Autowired
	private UserRepository userRepository;
	
	public User user(String id) {
		try {
			Optional<User> optional = userRepository.findById(id);
			User user = optional.get();
			return user;
		}catch (Exception e) {
			throw new UserNotFoundException("User not found", id);
		}

	}
}
