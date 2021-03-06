package ua.jackson.awsPractice.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import ua.jackson.awsPractice.entity.Abiturient;
import java.util.Set;


public class FacultyDto {

    @JsonIgnoreProperties("abiturients")
    private Set<Abiturient> abiturients;

    public Set<Abiturient> getAbiturients() {
        return abiturients;
    }

    public void setAbiturients(Set<Abiturient> abiturients) {
        this.abiturients = abiturients;
    }


    public FacultyDto(Set<Abiturient> abiturients) {
        this.abiturients = abiturients;
    }
}
