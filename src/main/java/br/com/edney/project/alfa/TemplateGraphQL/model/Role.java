package br.com.edney.project.alfa.TemplateGraphQL.model;

import java.util.Collection;

import org.springframework.data.mongodb.core.mapping.DBRef;

import lombok.Data;

@Data
public class Role extends BaseEntity{
	private String name;
	@DBRef(lazy = true)
	private Collection<User> users;
	@DBRef(lazy = true)
	private Collection<Privilege> privileges;
	
	
    public Role() {
        super();
    }

    public Role(final String name) {
        super();
        this.name = name;
    }
}
