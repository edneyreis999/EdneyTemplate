package br.com.edney.project.alfa.TemplateGraphQL.resolvers;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import com.coxautodev.graphql.tools.GraphQLMutationResolver;

import br.com.edney.project.alfa.TemplateGraphQL.model.Role;
import br.com.edney.project.alfa.TemplateGraphQL.model.User;
import br.com.edney.project.alfa.TemplateGraphQL.repository.RoleRepository;
import br.com.edney.project.alfa.TemplateGraphQL.repository.UserRepository;
import graphql.schema.DataFetchingEnvironment;

@Component
public class Mutation implements GraphQLMutationResolver{
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private RoleRepository roleRepository;
	
    @Autowired
    private PasswordEncoder passwordEncoder;
	
    public User createUser(Map<String,String> createUserInput, DataFetchingEnvironment env) {
    	// Get paramters from request
    	String userName = createUserInput.get("userName");
        String email = createUserInput.get("email");
        String password = passwordEncoder.encode(createUserInput.get("password"));
        
        //TODO validar se o e-mail já existe
        /*
        if (emailExist(accountDto.getEmail())) {
            throw new EmailExistsException
              ("There is an account with that email adress: " + accountDto.getEmail());
        }
        */
        List<Role> roleList = Arrays.asList(roleRepository.findByName("ROLE_USER"));
        // create new user
        User user = new User(userName, password, email, true, roleList);
        User userSaved = userRepository.save(user);
        
    	return userSaved;
    }
}
