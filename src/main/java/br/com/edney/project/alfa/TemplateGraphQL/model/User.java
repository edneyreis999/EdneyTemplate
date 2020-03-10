package br.com.edney.project.alfa.TemplateGraphQL.model;

import java.util.Collection;

import org.springframework.data.mongodb.core.mapping.DBRef;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class User extends BaseEntity{
    private String userName;
    private String password;
    private String email;
    private boolean enabled;
    
    @DBRef(lazy = true)
    private Collection<Role> roles;
}
