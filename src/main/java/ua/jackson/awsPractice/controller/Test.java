package ua.jackson.awsPractice.controller;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Test {

    @JsonProperty("name")
    private String name;
    @JsonProperty("surname")
    private String surname;

    public Test(String name, String surname) {
        this.name = name;
        this.surname = surname;
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

    @Override
    public String toString() {
        return "Test{" +
                "name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                '}';
    }
}
