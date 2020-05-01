package ua.jackson.awsPractice.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

@Entity
@JsonIgnoreProperties(ignoreUnknown = true)
public class Faculty {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long facultyIdl;

    private String facultyName;

    @ManyToMany
    @JsonIgnoreProperties("faculties")
//    @OnDelete(action = OnDeleteAction.CASCADE)
    private Set<Abiturient> abiturients;

    @OneToMany
    @JsonIgnoreProperties("abiturients")
    private List<Specialization> specializations;

    public Faculty() {
    }

    public Long getFacultyIdl() {
        return facultyIdl;
    }

    public void setFacultyIdl(Long facultyIdl) {
        this.facultyIdl = facultyIdl;
    }

    public String getFacultyName() {
        return facultyName;
    }

    public void setFacultyName(String facultyName) {
        this.facultyName = facultyName;
    }

    public List<Specialization> getSpecializations() {
        return specializations;
    }

    public void setSpecializations(List<Specialization> specializations) {
        this.specializations = specializations;
    }


    public Faculty(Long facultyIdl, String facultyName, Set<Abiturient> abiturients, List<Specialization> specializations) {
        this.facultyIdl = facultyIdl;
        this.facultyName = facultyName;
        this.abiturients = abiturients;
        this.specializations = specializations;
    }

    public Set<Abiturient> getAbiturients() {
        return abiturients;
    }

    public void setAbiturients(Set<Abiturient> abiturients) {
        this.abiturients = abiturients;
    }

    @Override
    public String toString() {
        return "Faculty{" +
                "facultyIdl=" + facultyIdl +
                ", facultyName='" + facultyName + '\'' +
                ", specializations=" + specializations +
                '}';
    }
}
