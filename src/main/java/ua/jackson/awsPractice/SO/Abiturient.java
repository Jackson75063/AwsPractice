/*
package ua.jackson.awsPractice.SO;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "Abiturient222")
public class Abiturient {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;
    private LocalDateTime documentPassDate;
    private Integer requestCounter;

    public Abiturient() {
    }

    @ManyToMany(cascade = {CascadeType.MERGE})
    @JoinTable(name="depart_abit",
            joinColumns=@JoinColumn(name="abitId"),
            inverseJoinColumns=@JoinColumn(name="departId"))
    @JsonIgnoreProperties("abitturs")
    private List<Depart> departs;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDateTime getDocumentPassDate() {
        return documentPassDate;
    }

    public void setDocumentPassDate(LocalDateTime documentPassDate) {
        this.documentPassDate = documentPassDate;
    }

    public int getRequestCounter() {
        return requestCounter;
    }

    public void setRequestCounter(int requestCounter) {
        this.requestCounter = requestCounter;
    }

    public List<Depart> getDeparts() {
        return departs;
    }

    public void setDeparts(List<Depart> departs) {
        this.departs = departs;
    }

   */
/* @ManyToMany
    @JoinTable(name = "tbl_departs2",
            joinColumns = @JoinColumn(name = "personId"),
            inverseJoinColumns = @JoinColumn
    )
    private Set<Depart> departs2;*//*


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Abiturient that = (Abiturient) o;
        return requestCounter == that.requestCounter &&
                Objects.equals(id, that.id) &&
                Objects.equals(documentPassDate, that.documentPassDate) &&
                Objects.equals(departs, that.departs);
    }

    public void setRequestCounter(Integer requestCounter) {
        this.requestCounter = requestCounter;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, documentPassDate, requestCounter, departs);
    }
}
*/
