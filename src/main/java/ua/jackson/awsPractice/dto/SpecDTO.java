package ua.jackson.awsPractice.dto;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

public class SpecDTO {

    private Long id;

    private Short specializationCode;

    private String specializationName;


    public SpecDTO(Long id, Short specializationCode, String specializationName) {
        this.id = id;
        this.specializationCode = specializationCode;
        this.specializationName = specializationName;
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


}
