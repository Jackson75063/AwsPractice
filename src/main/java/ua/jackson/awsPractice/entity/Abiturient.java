package ua.jackson.awsPractice.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.List;
import java.util.Map;

@Entity
public class Abiturient {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idAbitCode;

    private String name;
    private String surname;
    private Double avgDiplomaMark;
    @ManyToMany()
    @JsonIgnoreProperties("abiturients")
    private List<Faculty> faculties;

    private Integer requestCounter;

    @ElementCollection(fetch = FetchType.LAZY)
    @CollectionTable(name = "ZNO_MARK", foreignKey = @ForeignKey(name = "ZNO_BALU"), joinColumns = @JoinColumn(name = "abit_id"))
    @MapKeyColumn(name = "Subject", length = 40)
    @MapKeyClass(Subject.class)
    @MapKeyEnumerated(EnumType.STRING)
    private Map<Subject,Float> znoSubjectList;

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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public Map<Subject, Float> getZnoSubjectList() {
        return znoSubjectList;
    }

    public void setZnoSubjectList(Map<Subject, Float> znoSubjectList) {
        this.znoSubjectList = znoSubjectList;
    }
}
