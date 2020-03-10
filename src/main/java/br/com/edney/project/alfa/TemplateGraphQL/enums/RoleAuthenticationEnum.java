package br.com.edney.project.alfa.TemplateGraphQL.enums;

public enum RoleAuthenticationEnum {
	ROLE_ADMIN,
	ROLE_USER;
	
	
    public static RoleAuthenticationEnum getByName(String roleName) {
        for (RoleAuthenticationEnum e : values()) {
            if (e.name().equalsIgnoreCase(roleName)) return e;
        }
        return null;
    }
}
