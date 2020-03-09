package br.com.edney.project.alfa.TemplateGraphQL.security;

import org.springframework.stereotype.Component;

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
        claims.put("role", user.getRole());
        claims.put("email", user.getEmail());

        return Jwts.builder()
                .setClaims(claims)
                .signWith(SignatureAlgorithm.HS512, "Graphql")
                .compact();
    }
}
