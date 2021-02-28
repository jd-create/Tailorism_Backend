package nl.novi.jdemeijervandriel.tailorism.domain;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "api_order")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    @Column(name = "order_id")
    private long id;
    @Column
    private String timeOfOrder;


    @ManyToMany
    @JoinTable(name = "order_product",
    joinColumns = @JoinColumn(name = "order_id"),
    inverseJoinColumns = @JoinColumn(name = "product_id"))
    private Set<Product> productSet;

    @ManyToOne
    @JoinColumn(name = "customer_id", referencedColumnName = "id")
    private Customer customer;


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

    public Set<Product> getProductSet() {
        return productSet;
    }

    public void setProductSet(Set<Product> productSet) {
        this.productSet = productSet;
    }


}
