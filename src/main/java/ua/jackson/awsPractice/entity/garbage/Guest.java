/*
package ua.jackson.awsPractice.entity.garbage;

import org.hibernate.annotations.Proxy;
import org.springframework.context.annotation.Lazy;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Objects;

@Entity
@Proxy(lazy = false)
@Lazy()
public class Guest {

    @Id
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

    public Guest() {
    }

    public Guest(Long id, String name, String surname) {
        this.id = id;
        this.name = name;
        this.surname = surname;
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
        Guest guest = (Guest) o;
        return Objects.equals(id, guest.id) &&
                Objects.equals(name, guest.name) &&
                Objects.equals(surname, guest.surname);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, surname);
    }
}
*/
