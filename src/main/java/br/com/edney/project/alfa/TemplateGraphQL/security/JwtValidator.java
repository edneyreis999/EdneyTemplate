package br.com.edney.project.alfa.TemplateGraphQL.security;

import org.springframework.stereotype.Component;

import br.com.edney.project.alfa.TemplateGraphQL.model.User;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;

@Component
public class JwtValidator {
    private String secret = "Graphql";

    public User validate(String token) {
    	User jwtUser = null;
        try {
            Claims body = Jwts.parser()
                    .setSigningKey(secret)
                    .parseClaimsJws(token)
                    .getBody();

            String userName = body.getSubject();
			String password = (String) body.get("password");
			String role = (String) body.get("role");
			String email = (String) body.get("email");
			jwtUser = new User(userName, password, role, email);
        }
        catch (Exception e) {
            System.out.println(e);
        }

        return jwtUser;
    }
}