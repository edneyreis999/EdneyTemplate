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

            jwtUser = new User();

            jwtUser.setUserName(body.getSubject());
            jwtUser.setPassword((String) body.get("userId"));
            jwtUser.setRole((String) body.get("role"));
        }
        catch (Exception e) {
            System.out.println(e);
        }

        return jwtUser;
    }
}