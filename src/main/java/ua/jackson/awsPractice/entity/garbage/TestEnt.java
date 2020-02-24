package ua.jackson.awsPractice.entity;

import javax.persistence.*;
import java.util.Set;

@Entity
public class TestEnt {

    @Id
    private Long id;

    @Enumerated(value = EnumType.STRING)
    @Column(name = "subjects", nullable = false)
    @ElementCollection(targetClass = Subject.class)
    private Set<Subject> subject;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Set<Subject> getSubject() {
        return subject;
    }

    public void setSubject(Set<Subject> subject) {
        this.subject = subject;
    }

    public TestEnt() {
    }


    @Override
    public String toString() {
        return "TestEnt{" +
                "id=" + id +
                ", subject=" + subject +
                '}';
    }
}
