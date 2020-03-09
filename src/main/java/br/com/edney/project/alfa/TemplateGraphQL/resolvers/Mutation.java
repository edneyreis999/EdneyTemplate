package br.com.edney.project.alfa.TemplateGraphQL.resolvers;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.coxautodev.graphql.tools.GraphQLMutationResolver;

import br.com.edney.project.alfa.TemplateGraphQL.model.User;
import br.com.edney.project.alfa.TemplateGraphQL.repository.UserRepository;

@Component
public class Mutation implements GraphQLMutationResolver{
	
	@Autowired
	private UserRepository userRepository;
	
    public User createUser(Map<String,String> createUserInput) {
    	// Get paramters from request
    	String userName = createUserInput.get("userName");
        String email = createUserInput.get("email");
        String role = createUserInput.get("role");
        String password = createUserInput.get("password");
        
        // create new user
        User user = new User(userName, password, role, email);
        User userSaved = userRepository.save(user);
        
    	return userSaved;
    }
}
