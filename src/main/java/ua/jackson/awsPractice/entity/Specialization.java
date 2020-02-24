package ua.jackson.awsPractice.entity;

import javax.persistence.*;
import java.util.Set;

@Entity
public class Specialization {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Short specializationCode;

    private String specializationName;

    @Enumerated(value = EnumType.STRING)
    @Column(name = "requiredSubjects", nullable = false)
    @ElementCollection(targetClass = Subject.class)
    Set<Subject> requiredSubjects;

    @Enumerated(value = EnumType.STRING)
    @Column(name = "optionalSubjects", nullable = false)
    @ElementCollection(targetClass = Subject.class)
    Set<Subject> optionalSubjecst;

    @Override
    public String toString() {
        return "Specialization{" +
                "id=" + id +
                ", specializationCode=" + specializationCode +
                ", specializationName='" + specializationName + '\'' +
                ", requiredSubjects=" + requiredSubjects +
                ", optionalSubjecst=" + optionalSubjecst +
                '}';
    }

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

    public Set<Subject> getRequiredSubjects() {
        return requiredSubjects;
    }

    public void setRequiredSubjects(Set<Subject> requiredSubjects) {
        this.requiredSubjects = requiredSubjects;
    }

    public Set<Subject> getOptionalSubjecst() {
        return optionalSubjecst;
    }

    public void setOptionalSubjecst(Set<Subject> optionalSubjecst) {
        this.optionalSubjecst = optionalSubjecst;
    }
}
/*

{
        "id":1,
        "specializationCode" : 10,
        "specializationName" : "newName",
        "requiredSubjects" : ["MATH"],
        "optionalSubjecst" : ["MATH"]
        }
        */
