package br.com.edney.project.alfa.TemplateGraphQL.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
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
	
    @Autowired
    private PasswordEncoder passwordEncoder;

    public LoginController(JwtGenerator jwtGenerator) {
        this.jwtGenerator = jwtGenerator;
    }

    @PostMapping
    public String generate(@RequestBody final User jwtUser) {
        String email = jwtUser.getEmail();
		String password = jwtUser.getPassword();
		
		User user = userRepository.findByEmail(email);
		if(user != null) {
			boolean passwordMatches = passwordEncoder.matches(password, user.getPassword());
			if(passwordMatches) {
				return jwtGenerator.generate(user);
			}else {
				throw new UserNotFoundException("Password errado");
			}
		}else {
			throw new UserNotFoundException("Password errado");
		}

    }
}
