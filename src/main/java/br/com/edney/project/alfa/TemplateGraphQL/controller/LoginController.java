package br.com.edney.project.alfa.TemplateGraphQL.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.edney.project.alfa.TemplateGraphQL.model.User;
import br.com.edney.project.alfa.TemplateGraphQL.security.JwtGenerator;

@RestController
@RequestMapping("/login")
public class LoginController {
    private JwtGenerator jwtGenerator;

    public LoginController(JwtGenerator jwtGenerator) {
        this.jwtGenerator = jwtGenerator;
    }

    @PostMapping
    public String generate(@RequestBody final User jwtUser) {

        return jwtGenerator.generate(jwtUser);

    }
}
