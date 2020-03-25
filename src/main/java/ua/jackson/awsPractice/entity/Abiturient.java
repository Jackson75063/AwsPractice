package ua.jackson.awsPractice.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;
import ua.jackson.awsPractice.maptest.ZNOOneSubject;
import ua.jackson.awsPractice.models.Role;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


@Entity
@Table(	name = "Abiturients",
        uniqueConstraints = {
                @UniqueConstraint(columnNames = "username"),
                @UniqueConstraint(columnNames = "email")
        })
public class Abiturient {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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



    @ManyToMany()
    @JsonIgnoreProperties("abiturients")
    @OnDelete(action = OnDeleteAction.CASCADE)
    private List<Faculty> faculties;

    private Integer requestCounter;

    @ElementCollection
    private Set<ZNOOneSubject> subjs = new HashSet<>(4);

    public Abiturient(String username, String email, String password) {
        this.username = username;
        this.email = email;
        this.password = password;
    }


//    @ElementCollection(fetch = FetchType.LAZY)
//    @CollectionTable(name = "ZNO_MARK", foreignKey = @ForeignKey(name = "ZNO_BALU"), joinColumns = @JoinColumn(name = "abit_id"))
//    @MapKeyColumn(name = "Subject", length = 40)
//    @MapKeyClass(Subject.class)
//    @MapKeyEnumerated(EnumType.STRING)
//    private Map<Subject,Float> znoSubjectList;

    public Set<ZNOOneSubject> getSubjs() {
        return subjs;
    }

    public void setSubjs(Set<ZNOOneSubject> subjs) {
        this.subjs = subjs;
    }

    /*
    @JoinTable(name = "subjectTable", joinColumns = @JoinColumn(name = "idAbitCode"))
    @Column(name = "subjects", nullable = false)
    @Enumerated(EnumType.STRING)
    @ElementCollection(targetClass = Subject.class)
    private List<Subject> znoSubjectList;
*/

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
                ", requestCounter=" + requestCounter +
                ", subjs=" + subjs +
                '}';
    }
}
