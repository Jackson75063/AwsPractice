package ua.jackson.awsPractice.SO;

import javax.persistence.*;
import java.util.List;

@Entity
public class Depart {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long   id;
    private String firstName;
    private String lastName;
    private Double avg;
    private String country;

    @ManyToMany
    @JoinTable(name="depart_abit",
            joinColumns=@JoinColumn(name="departId"),
            inverseJoinColumns=@JoinColumn(name="abitId")
    )
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


    public void setAbitturs(List<Abiturient> abitturs) {
        this.abitturs = abitturs;
    }

    /*
    @ManyToMany()
    @JoinTable(
            name = "Depart_ student",
            joinColumns =  @JoinColumn(name = "Depart_id"),
            inverseJoinColumns = @JoinColumn(name = "abiturient_id"))
    private Set<Abiturient> abiturients;
  */

}
