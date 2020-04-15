package ua.jackson.awsPractice.security.service;


import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import ua.jackson.awsPractice.entity.Abiturient;
import ua.jackson.awsPractice.models.ZNOOneSubject;

import java.util.*;
import java.util.stream.Collectors;

public class AbitDetailsImpl implements UserDetails {
    private static final long serialVersionUID = 1L;

    private Long id;
    private String username;
    private String surname;
    private String email;

    @JsonIgnore
    private String password;

    private Collection<? extends GrantedAuthority> authorities;

    private Set<ZNOOneSubject> subjs;

    public AbitDetailsImpl(Long id, String username, String surname, String email, String password,
                           Collection<? extends GrantedAuthority> authorities, Set<ZNOOneSubject> subjs) {
        this.id = id;
        this.username = username;
        this.surname = surname;
        this.email = email;
        this.password = password;
        this.authorities = authorities;
        this.subjs = subjs;
    }

    public static AbitDetailsImpl build(Abiturient abiturient) {
        List<GrantedAuthority> authorities = abiturient.getRoles().stream()
                .map(role -> new SimpleGrantedAuthority(role.getName().name()))
                .collect(Collectors.toList());

        return new AbitDetailsImpl(
                abiturient.getIdAbitCode(),
                abiturient.getUsername(),
                abiturient.getSurname(),
                abiturient.getEmail(),
                abiturient.getPassword(),
                authorities,
                abiturient.getSubjs());
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
    }

    public Long getId() {
        return id;
    }

    public String getEmail() {
        return email;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return username;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
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

    public Set<ZNOOneSubject> getSubjs() {
        return subjs;
    }

    public void setSubjs(Set<ZNOOneSubject> subjs) {
        this.subjs = subjs;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        AbitDetailsImpl user = (AbitDetailsImpl) o;
        return Objects.equals(id, user.id);
    }
}
