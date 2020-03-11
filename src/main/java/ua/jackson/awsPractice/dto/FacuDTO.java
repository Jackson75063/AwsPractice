package ua.jackson.awsPractice.dto;


import java.util.Set;

public class FacuDTO {

    private Long facultyIdl;

    private String facultyName;

    private Set<SpecDTO> specializations;


    public FacuDTO(Long facultyIdl, String facultyName, Set<SpecDTO> specializations) {
        this.facultyIdl = facultyIdl;
        this.facultyName = facultyName;
        this.specializations = specializations;
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

    public Set<SpecDTO> getSpecializations() {
        return specializations;
    }

    public void setSpecializations(Set<SpecDTO> specializations) {
        this.specializations = specializations;
    }
}
