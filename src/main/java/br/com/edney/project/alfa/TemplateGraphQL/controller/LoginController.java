package br.com.edney.project.alfa.TemplateGraphQL.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.edney.project.alfa.TemplateGraphQL.exception.user.UserNotFoundException;
import br.com.edney.project.alfa.TemplateGraphQL.model.User;
import br.com.edney.project.alfa.TemplateGraphQL.repository.UserRepository;
import br.com.edney.project.alfa.TemplateGraphQL.security.JwtGenerator;

@RestController
@RequestMapping("/login")
public class LoginController {
    private JwtGenerator jwtGenerator;
    
	@Autowired
	private UserRepository userRepository;

    public LoginController(JwtGenerator jwtGenerator) {
        this.jwtGenerator = jwtGenerator;
    }

    @PostMapping
    public String generate(@RequestBody final User jwtUser) {
        String email = jwtUser.getEmail();
		String password = jwtUser.getPassword();
		
		try {
			List<User> users = userRepository.findByEmailAndPassword(email, password);
			User user = users.get(0);

	        return jwtGenerator.generate(user);
		}catch (Exception e) {
			throw new UserNotFoundException("User not found");
		}


    }
}
