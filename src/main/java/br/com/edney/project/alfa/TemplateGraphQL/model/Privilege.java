package br.com.edney.project.alfa.TemplateGraphQL.model;

import java.util.Collection;

import org.springframework.data.mongodb.core.mapping.DBRef;

import lombok.Data;

@Data
public class Privilege extends BaseEntity{

	private String name;
	
	@DBRef(lazy = true)
	private Collection<Role> roles;
	
    public Privilege() {
        super();
    }

    public Privilege(final String name) {
        super();
        this.name = name;
    }
}
