package ua.jackson.awsPractice.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import ua.jackson.awsPractice.entity.Faculty;
import ua.jackson.awsPractice.entity.Specialization;
import ua.jackson.awsPractice.models.Role;
import ua.jackson.awsPractice.models.ZNOOneSubject;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class AbitDTO {


        private Long idAbitCode;
        private String username;
        private String surname;
        private String poBatkovi;
        private Double avgDiplomaMark;

        private String email;

        private String password;

        private Set<Role> roles = new HashSet<>();


        private List<Faculty> faculties;

        private List<Specialization> specializations;

        private Integer requestCounter;

        private Set<ZNOOneSubject> subjs = new HashSet<>(4);


        public List<Specialization> getSpecializations() {
            return specializations;
        }

        public void setSpecializations(List<Specialization> specializations) {
            this.specializations = specializations;
        }

        public AbitDTO(String username, String email, String password) {
            this.username = username;
            this.email = email;
            this.password = password;
        }

        public Set<ZNOOneSubject> getSubjs() {
            return subjs;
        }

        public void setSubjs(Set<ZNOOneSubject> subjs) {
            this.subjs = subjs;
        }

        public AbitDTO() {
        }

        public Long getIdAbitCode() {
            return idAbitCode;
        }

        public void setIdAbitCode(Long idAbitCode) {
            this.idAbitCode = idAbitCode;
        }

        public String getUsername() {
            return username;
        }

        public void setUsername(String name) {
            this.username = name;
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


        public String getPoBatkovi() {
            return poBatkovi;
        }

        public void setPoBatkovi(String poBatkovi) {
            this.poBatkovi = poBatkovi;
        }

        public String getEmail() {
            return email;
        }

        public void setEmail(String email) {
            this.email = email;
        }

        public String getPassword() {
            return password;
        }

        public void setPassword(String password) {
            this.password = password;
        }

        public Set<Role> getRoles() {
            return roles;
        }

        public void setRoles(Set<Role> roles) {
            this.roles = roles;
        }


    public AbitDTO(Long idAbitCode, String surname, String poBatkovi, Double avgDiplomaMark, List<Faculty> faculties, Integer requestCounter, Set<ZNOOneSubject> subjs, List<Specialization> specializations) {
        this.idAbitCode = idAbitCode;
        this.surname = surname;
        this.poBatkovi = poBatkovi;
        this.avgDiplomaMark = avgDiplomaMark;
        this.faculties = faculties;
        this.requestCounter = requestCounter;
        this.subjs = subjs;
        this.specializations = specializations;
    }

    @Override
    public String toString() {
        return "AbitDTO{" +
                "idAbitCode=" + idAbitCode +
                ", username='" + username + '\'' +
                ", surname='" + surname + '\'' +
                ", poBatkovi='" + poBatkovi + '\'' +
                ", avgDiplomaMark=" + avgDiplomaMark +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", roles=" + roles +
                ", faculties=" + faculties +
                ", specializations=" + specializations +
                ", requestCounter=" + requestCounter +
                ", subjs=" + subjs +
                '}';
    }
}
