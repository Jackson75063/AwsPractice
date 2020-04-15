package ua.jackson.awsPractice.payload.request;

import ua.jackson.awsPractice.entity.Faculty;

import java.util.List;

public class SetFacultyRequest {

    private List<Faculty> faculties;

    public SetFacultyRequest(List<Faculty> faculties) {
        this.faculties = faculties;
    }

    public List<Faculty> getFaculties() {
        return faculties;
    }

    public void setFaculties(List<Faculty> faculties) {
        this.faculties = faculties;
    }
}
