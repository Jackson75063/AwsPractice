/*
package ua.jackson.awsPractice.SO;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "Depart")
public class Depart {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long   id;
    private String firstName;
    private String lastName;
    private Double avg;
    private String country;

    @ManyToMany(cascade = {CascadeType.MERGE})
    @JoinTable(name="depart_abit",
            joinColumns=@JoinColumn(name="departId"),
            inverseJoinColumns=@JoinColumn(name="abitId"))
    @JsonIgnoreProperties("departs")
    private List<Abiturient> abitturs;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Double getAvg() {
        return avg;
    }

    public void setAvg(Double avg) {
        this.avg = avg;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public List<Abiturient> getAbitturs() {
        return abitturs;
    }

    public void setAbitturs(List<Abiturient> abitturs) {
        this.abitturs = abitturs;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Depart depart = (Depart) o;
        return Objects.equals(id, depart.id) &&
                Objects.equals(firstName, depart.firstName) &&
                Objects.equals(lastName, depart.lastName) &&
                Objects.equals(avg, depart.avg) &&
                Objects.equals(country, depart.country) &&
                Objects.equals(abitturs, depart.abitturs);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, firstName, lastName, avg, country, abitturs);
    }

    public Depart() {
    }

    */
/*
    @ManyToMany()
    @JoinTable(
            name = "Depart_ student",
            joinColumns =  @JoinColumn(name = "Depart_id"),
            inverseJoinColumns = @JoinColumn(name = "abiturient_id"))
    private Set<Abiturient> abiturients;
  *//*


}
*/
