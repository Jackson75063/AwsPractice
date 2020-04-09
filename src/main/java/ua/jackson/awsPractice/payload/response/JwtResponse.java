package ua.jackson.awsPractice.payload.response;

import ua.jackson.awsPractice.maptest.ZNOOneSubject;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class JwtResponse {
    private String token;
    private String type = "Bearer";
    private Long id;
    private String username;
    private String surname;
    private String email;
    private List<String> roles;
//    private Set<ZNOOneSubject> subjs = new HashSet<>(4);

    public JwtResponse(String accessToken, Long id, String username, String surname, String email, List<String> roles/*, Set<ZNOOneSubject> subjs*/) {
        this.token = accessToken;
        this.id = id;
        this.username = username;
        this.surname = surname;
        this.email = email;
        this.roles = roles;
//        this.subjs = subjs;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getAccessToken() {
        return token;
    }

    public void setAccessToken(String accessToken) {
        this.token = accessToken;
    }

    public String getTokenType() {
        return type;
    }

    public void setTokenType(String tokenType) {
        this.type = tokenType;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public List<String> getRoles() {
        return roles;
    }

//    public Set<ZNOOneSubject> getSubjs() {
//        return subjs;
//    }

//    public void setSubjs(Set<ZNOOneSubject> subjs) {
//        this.subjs = subjs;
//    }
}
