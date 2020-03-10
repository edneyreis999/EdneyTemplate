package br.com.edney.project.alfa.TemplateGraphQL.security;

import java.util.ArrayList;
import java.util.Collection;

import org.springframework.stereotype.Component;

import br.com.edney.project.alfa.TemplateGraphQL.enums.RoleAuthenticationEnum;
import br.com.edney.project.alfa.TemplateGraphQL.model.Role;
import br.com.edney.project.alfa.TemplateGraphQL.model.User;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;


/**
 * 
 * @author edney
 * The JwtGeneratoris responsible for performing JWT operations like creation. 
 * It makes use of the package io.jsonwebtoken.Jwts for achieving this.
 */
@Component
public class JwtGenerator {
    public String generate(User user) {
        Claims claims = Jwts.claims().setSubject(user.getUserName());
        claims.put("password", String.valueOf(user.getPassword()));
        claims.put("email", user.getEmail());
        
		ArrayList<RoleAuthenticationEnum> userRolesName = new ArrayList<RoleAuthenticationEnum>();
		Collection<Role> userRoles = user.getRoles();
		for (Role role : userRoles) {
			userRolesName.add(RoleAuthenticationEnum.getByName(role.getName()));
		}
        claims.put("roles", userRolesName);

        return Jwts.builder()
                .setClaims(claims)
                .signWith(SignatureAlgorithm.HS512, "Graphql")
                .compact();
    }
}
