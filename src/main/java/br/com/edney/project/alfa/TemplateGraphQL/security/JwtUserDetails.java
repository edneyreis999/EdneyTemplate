package br.com.edney.project.alfa.TemplateGraphQL.security;

import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class JwtUserDetails implements UserDetails {
	private static final long serialVersionUID = 6040305095125536455L;
	private String userName;
    private String token;
    private String password;
    private Collection<? extends GrantedAuthority> authorities;
    private String email;

    public JwtUserDetails(String userName, String password, String token, List<GrantedAuthority> grantedAuthorities, String email) {
        this.userName = userName;
        this.password = password;
        this.token= token;
        this.authorities = grantedAuthorities;
        this.email = email;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return userName;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}