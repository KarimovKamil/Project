package ru.itis.inform.security.user;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;

/**
 * 30.10.2016.
 *
 * @author Maxim Romanov
 */

public class UserDetailsImpl implements UserDetails {

    private String phone;
    private String hashPassword;
    private List<GrantedAuthority> authorities;


    public UserDetailsImpl(String phone, String hashPassword, List<GrantedAuthority> authorities) {
        this.phone = phone;
        this.hashPassword = hashPassword;
        this.authorities = authorities;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
    }

    @Override
    public String getPassword() {
        return null;
    }

    @Override
    public String getUsername() {
        return null;
    }

    @Override
    public boolean isAccountNonExpired() {
        return false;
    }

    @Override
    public boolean isAccountNonLocked() {
        return false;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return false;
    }

    @Override
    public boolean isEnabled() {
        return false;
    }
}