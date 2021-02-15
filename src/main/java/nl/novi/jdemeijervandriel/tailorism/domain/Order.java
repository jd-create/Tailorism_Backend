package nl.novi.jdemeijervandriel.tailorism.domain;



import javax.persistence.*;

@Entity
@Table(name = "api_order")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    @Column(columnDefinition = "serial")
    private long id;
    private String timeOfOrder;

    public Order(){}

    public Order(String timeOfOrder){
        this.timeOfOrder = timeOfOrder;

    }

    public String getTimeOfOrder() {
        return timeOfOrder;
    }

    public void setTimeOfOrder(String timeOfOrder) {
        this.timeOfOrder = timeOfOrder;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
}
