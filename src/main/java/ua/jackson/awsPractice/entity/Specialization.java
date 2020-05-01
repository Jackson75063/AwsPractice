package ua.jackson.awsPractice.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@JsonIgnoreProperties(ignoreUnknown = true)
public class Specialization {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Short specializationCode;

    private String specializationName;

    @Enumerated(value = EnumType.STRING)
    @Column(name = "subjects", nullable = false)
    @ElementCollection(targetClass = Subject.class)
    Set<Subject> needSubjects = new HashSet<>();

    @OneToMany
    @JsonIgnoreProperties("abiturients")
    private List<Abiturient> abiturients;

    public List<Abiturient> getAbiturients() {
        return abiturients;
    }

    public void setAbiturients(List<Abiturient> abiturients) {
        this.abiturients = abiturients;
    }

    /*    @ManyToMany(mappedBy = "idAbitCode")
    @JsonIgnoreProperties("Specialization")
//    @OnDelete(action = OnDeleteAction.CASCADE)
    private Set<Abiturient> abiturients;
    */


/*
    @ManyToOne
    @JoinColumn(name="abit_id", nullable=false)
    private Abiturient abiturients;
*/

    /*
    @ManyToMany(cascade = {CascadeType.MERGE})
    @JoinTable(name = "abit_speccs",
            joinColumns = @JoinColumn(name = "specc_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "abit_id", referencedColumnName = "id"),
            uniqueConstraints={@UniqueConstraint(columnNames={"specc_id", "abit_id"})})
    @JsonIgnoreProperties("specialization")
    private List<Abiturient> abiturients;
*/

    public Set<Subject> getNeedSubjects() {
        return needSubjects;
    }

    public void setNeedSubjects(Set<Subject> needSubjects) {
        this.needSubjects = needSubjects;
    }



   /*
    @Enumerated(value = EnumType.STRING)
    @Column(name = "optionalSubjects", nullable = false)
    @ElementCollection(targetClass = Subject.class)
    Set<Subject> optionalSubjecst;*/

  /*  @Override
    public String toString() {
        return "Specialization{" +
                "id=" + id +
                ", specializationCode=" + specializationCode +
                ", specializationName='" + specializationName + '\'' +
                ", requiredSubjects=" + requiredSubjects +
                ", optionalSubjecst=" + optionalSubjecst +
                '}';
    }*/

    public Specialization() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Short getSpecializationCode() {
        return specializationCode;
    }

    public void setSpecializationCode(Short specializationCode) {
        this.specializationCode = specializationCode;
    }

    public String getSpecializationName() {
        return specializationName;
    }

    public void setSpecializationName(String specializationName) {
        this.specializationName = specializationName;
    }


    public Specialization(Long id, Short specializationCode, String specializationName, Set<Subject> needSubjects, List<Abiturient> abiturients) {
        this.id = id;
        this.specializationCode = specializationCode;
        this.specializationName = specializationName;
        this.needSubjects = needSubjects;
        this.abiturients = abiturients;
    }

    @Override
    public String toString() {
        return "Specialization{" +
                "id=" + id +
                ", specializationCode=" + specializationCode +
                ", specializationName='" + specializationName + '\'' +
                ", needSubjects=" + needSubjects +
                '}';
    }
}
