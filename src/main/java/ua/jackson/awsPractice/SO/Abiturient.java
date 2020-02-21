package ua.jackson.awsPractice.SO;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Set;

@Entity
public class Abiturient {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;
    private LocalDateTime documentPassDate;
    private int requestCounter;

    @ManyToMany
    @JoinTable(name="depart_abit",
            joinColumns=@JoinColumn(name="abitId"),
            inverseJoinColumns=@JoinColumn(name="departId")
    )
    private Set<Depart> departs;

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

    public Set<Depart> getDeparts() {
        return departs;
    }



    /* @ManyToMany
    @JoinTable(name = "tbl_departs2",
            joinColumns = @JoinColumn(name = "personId"),
            inverseJoinColumns = @JoinColumn
    )
    private Set<Depart> departs2;*/

}
