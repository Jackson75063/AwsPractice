package ua.jackson.awsPractice.maptest;

import ua.jackson.awsPractice.entity.Subject;

import javax.persistence.*;
import java.util.*;

@Entity
public class MapTest {

    @Id
    private Long id;


    @ElementCollection
    private Set<ZNOOneSubject> subjs = new HashSet<>(4);

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public MapTest() {
    }

    public Set<ZNOOneSubject> getSubjs() {
        return subjs;
    }

    public void setSubjs(Set<ZNOOneSubject> subjs) {
        this.subjs = subjs;
    }

    @Override
    public String toString() {
        return "MapTest{" +
                "id=" + id +
                ", subjs=" + subjs +
                '}';
    }
}
