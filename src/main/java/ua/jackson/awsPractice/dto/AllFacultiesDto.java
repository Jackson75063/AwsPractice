package ua.jackson.awsPractice.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import ua.jackson.awsPractice.entity.Faculty;

import java.util.Set;

public class AllFacultiesDto {

    @JsonIgnoreProperties("specializations")
    Set<Faculty> faculties;

    public Set<Faculty> getFaculties() {
        return faculties;
    }

    public void setFaculties(Set<Faculty> faculties) {
        this.faculties = faculties;
    }
}
