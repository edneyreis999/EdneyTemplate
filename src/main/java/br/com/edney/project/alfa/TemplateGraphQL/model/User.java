package br.com.edney.project.alfa.TemplateGraphQL.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class User extends BaseEntity{
    private String userName;
    private String password;
    private String role;
    private String email;
}
