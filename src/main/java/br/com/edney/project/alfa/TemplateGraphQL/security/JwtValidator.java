package br.com.edney.project.alfa.TemplateGraphQL.security;

import java.util.Collection;

import org.springframework.stereotype.Component;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;

@Component
public class JwtValidator {
    private String secret = "Graphql";

    @SuppressWarnings("unchecked")
	public JwtUserDetails validate(String token) {
    	JwtUserDetails jwtUser = null;
        try {
            Claims body = Jwts.parser()
                    .setSigningKey(secret)
                    .parseClaimsJws(token)
                    .getBody();

            String userName = body.getSubject();
			String password = (String) body.get("password");
			String email = (String) body.get("email");
			Collection<String> roles = null;
			if(body.get("roles") instanceof Collection) {
				roles = (Collection<String>) body.get("roles");
			}
			
			jwtUser = new JwtUserDetails(userName, password, token, email, roles, null);
        }
        catch (Exception e) {
            System.out.println(e);
        }

        return jwtUser;
    }
}