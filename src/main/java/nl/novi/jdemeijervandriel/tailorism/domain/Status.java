package nl.novi.jdemeijervandriel.tailorism.domain;

import org.hibernate.annotations.GenericGenerator;
import javax.persistence.*;
import java.util.Set;

@Entity
public class Status {

    @Id
    @GeneratedValue
            (strategy = GenerationType.AUTO,
    generator="native")

    @GenericGenerator(
            name = "native",
            strategy = "native")

    @Column(columnDefinition = "serial")
    private long id;

    @Enumerated(EnumType.STRING)
    private EStatus name;

    @OneToMany
            (fetch=FetchType.LAZY,
                    mappedBy = "status",
                    cascade = CascadeType.ALL,
                    orphanRemoval = true)
    Set<Product> productSet;

    public Status(){}

    public EStatus getName() {
        return name;
    }

    public void setName(EStatus name) {
        this.name = name;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
}
