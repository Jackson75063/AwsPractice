package ua.jackson.awsPractice.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonView;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;
import ua.jackson.awsPractice.jsonVIew.Views;
import ua.jackson.awsPractice.models.ZNOOneSubject;
import ua.jackson.awsPractice.models.Role;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(	name = "Abiturients"
        /*uniqueConstraints = {
                @UniqueConstraint(columnNames = "username"),
                @UniqueConstraint(columnNames = "email")
        }*/)
//@JsonView(Views.Public.class)
public class Abiturient {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long idAbitCode;
    private String username;
    private String surname;
    private String poBatkovi;
    private Double avgDiplomaMark;

    @NotBlank
    @Size(max = 50)
    @Email
    private String email;

    @NotBlank
    @Size(max = 120)
    private String password;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(	name = "user_roles",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id"))
    private Set<Role> roles = new HashSet<>();


    @ManyToMany(cascade = CascadeType.PERSIST)
    @JsonIgnoreProperties("abiturients")
    @JoinTable(	name = "abit_faculties",
            joinColumns = @JoinColumn(name = "abit_id"),
            inverseJoinColumns = @JoinColumn(name = "faculty_id"))
    @OnDelete(action = OnDeleteAction.CASCADE)
    private List<Faculty> faculties;

    @ManyToMany(cascade = CascadeType.PERSIST)
    @JsonIgnoreProperties("abiturients")
    @JoinTable(	name = "abit_spec",
            joinColumns = @JoinColumn(name = "abit_id"),
            inverseJoinColumns = @JoinColumn(name = "spec_id"))
//    @OnDelete(action = OnDeleteAction.CASCADE)
    private List<Specialization> specializations;

    private Integer requestCounter = 5;

    @ElementCollection
    private Set<ZNOOneSubject> subjs = new HashSet<>(4);

    public List<Specialization> getSpecializations() {
        return specializations;
    }

    public void setSpecializations(List<Specialization> specializations) {
        this.specializations = specializations;
    }

    public Abiturient(String username, String email, String password) {
        this.username = username;
        this.email = email;
        this.password = password;
    }

    public Set<ZNOOneSubject> getSubjs() {
        return subjs;
    }

    public void setSubjs(Set<ZNOOneSubject> subjs) {
        this.subjs = subjs;
    }

    public Abiturient() {
    }

    public Long getIdAbitCode() {
        return idAbitCode;
    }

    public void setIdAbitCode(Long idAbitCode) {
        this.idAbitCode = idAbitCode;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String name) {
        this.username = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public Double getAvgDiplomaMark() {
        return avgDiplomaMark;
    }

    public void setAvgDiplomaMark(Double avgDiplomaMark) {
        this.avgDiplomaMark = avgDiplomaMark;
    }

    public List<Faculty> getFaculties() {
        return faculties;
    }

    public void setFaculties(List<Faculty> faculties) {
        this.faculties = faculties;
    }

    public Integer getRequestCounter() {
        return requestCounter;
    }

    public void setRequestCounter(Integer requestCounter) {
        this.requestCounter = requestCounter;
    }


    public String getPoBatkovi() {
        return poBatkovi;
    }

    public void setPoBatkovi(String poBatkovi) {
        this.poBatkovi = poBatkovi;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Set<Role> getRoles() {
        return roles;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }


    public Abiturient(Long idAbitCode, String surname, String poBatkovi, Double avgDiplomaMark, List<Faculty> faculties, Integer requestCounter, Set<ZNOOneSubject> subjs) {
        this.idAbitCode = idAbitCode;
        this.surname = surname;
        this.poBatkovi = poBatkovi;
        this.avgDiplomaMark = avgDiplomaMark;
        this.faculties = faculties;
        this.requestCounter = requestCounter;
        this.subjs = subjs;
    }

    public Abiturient(Long idAbitCode, String username, String surname, String poBatkovi, Double avgDiplomaMark, @NotBlank @Size(max = 50) @Email String email, @NotBlank @Size(max = 120) String password, Set<Role> roles, List<Faculty> faculties, List<Specialization> specccccccccccccccc, List<Specialization> specializations, Integer requestCounter, Set<ZNOOneSubject> subjs) {
        this.idAbitCode = idAbitCode;
        this.username = username;
        this.surname = surname;
        this.poBatkovi = poBatkovi;
        this.avgDiplomaMark = avgDiplomaMark;
        this.email = email;
        this.password = password;
        this.roles = roles;
        this.faculties = faculties;
        this.specializations = specializations;
        this.requestCounter = requestCounter;
        this.subjs = subjs;
    }

    @Override
    public String toString() {
        return "Abiturient{" +
                "idAbitCode=" + idAbitCode +
                ", username='" + username + '\'' +
                ", surname='" + surname + '\'' +
                ", poBatkovi='" + poBatkovi + '\'' +
                ", avgDiplomaMark=" + avgDiplomaMark +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", roles=" + roles +
                ", faculties=" + faculties +
                ", specializations=" + specializations +
                ", requestCounter=" + requestCounter +
                ", subjs=" + subjs +
                '}';
    }



    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Abiturient that = (Abiturient) o;
        return Objects.equals(idAbitCode, that.idAbitCode) &&
                Objects.equals(username, that.username) &&
                Objects.equals(surname, that.surname) &&
                Objects.equals(poBatkovi, that.poBatkovi) &&
                Objects.equals(avgDiplomaMark, that.avgDiplomaMark) &&
                Objects.equals(email, that.email) &&
                Objects.equals(password, that.password) &&
                Objects.equals(roles, that.roles) &&
                Objects.equals(faculties, that.faculties) &&
                Objects.equals(specializations, that.specializations) &&
                Objects.equals(requestCounter, that.requestCounter) &&
                Objects.equals(subjs, that.subjs);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idAbitCode, username, surname, poBatkovi, avgDiplomaMark, email, password, roles, faculties, specializations, requestCounter, subjs);
    }
}
