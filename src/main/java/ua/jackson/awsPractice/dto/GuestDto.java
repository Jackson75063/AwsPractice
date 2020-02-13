package ua.jackson.awsPractice.dto;

import ua.jackson.awsPractice.entity.Guest;

import javax.persistence.Id;
import java.util.Objects;

public class GuestDto {


    private Long id;

    private String name;
    private String surname;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public GuestDto() {
    }

    public GuestDto(Long id, String name, String surname) {
        this.id = id;
        this.name = name;
        this.surname = surname;
    }

    public void mapToDto(Guest guest){
        this.id = guest.getId();
        this.name = guest.getName();
        this.surname = guest.getSurname();

    }


    @Override
    public String toString() {
        return "Guest{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        GuestDto guestDto = (GuestDto) o;
        return Objects.equals(id, guestDto.id) &&
                Objects.equals(name, guestDto.name) &&
                Objects.equals(surname, guestDto.surname);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, surname);
    }
}
