package ua.jackson.awsPractice.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import java.util.Set;

@Entity
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
    private Set<Specialization> specializations;

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

    public Set<Specialization> getSpecializations() {
        return specializations;
    }

    public void setSpecializations(Set<Specialization> specializations) {
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

    /*public Set<Abiturient> getAbiturients() {
        return abiturients;
    }

    public void setAbiturients(Set<Abiturient> abiturients) {
        this.abiturients = abiturients;
    }*/
}
