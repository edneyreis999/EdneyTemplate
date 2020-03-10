package br.com.edney.project.alfa.TemplateGraphQL.resolvers;



import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.stereotype.Component;

import com.coxautodev.graphql.tools.GraphQLResolver;

import br.com.edney.project.alfa.TemplateGraphQL.enums.RoleAuthenticationEnum;
import br.com.edney.project.alfa.TemplateGraphQL.model.Role;
import br.com.edney.project.alfa.TemplateGraphQL.model.User;
import graphql.schema.DataFetchingEnvironment;

@Component
public class UserResolver implements GraphQLResolver<User>{
	public List<RoleAuthenticationEnum> roles(User user, DataFetchingEnvironment env){
		ArrayList<RoleAuthenticationEnum> userRolesName = new ArrayList<RoleAuthenticationEnum>();
		Collection<Role> userRoles = user.getRoles();
		for (Role role : userRoles) {
			userRolesName.add(RoleAuthenticationEnum.getByName(role.getName()));
		}
		return userRolesName;
	}
}
