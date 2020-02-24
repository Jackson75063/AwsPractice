package ua.jackson.awsPractice.dto;

import ua.jackson.awsPractice.entity.Abiturient;

import java.util.List;

public class AllAbitsDto {

    List<Abiturient> abiturients;

    public List<Abiturient> getAbiturients() {
        return abiturients;
    }

    public void setAbiturients(List<Abiturient> abiturients) {
        this.abiturients = abiturients;
    }
}
