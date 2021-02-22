package nl.novi.jdemeijervandriel.tailorism.domain;

import javax.persistence.*;
import java.math.BigDecimal;

//Article and Labor inherite from Product. Strategy is SINGLE_TABLE. Product_type distinguish the two.

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "product_type",discriminatorType = DiscriminatorType.INTEGER)
@Table(name = "product")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    @Column(columnDefinition = "serial")
    protected long id;
    @Column(name = "product_name")
    protected String productName;
    protected String description;
    protected BigDecimal price;

    @ManyToOne
    @JoinColumn(name = "status")
    protected Status status;


    public Product(){}

    public Product(String productName, String description, BigDecimal price, Status status){
        this.productName = productName;
        this.description = description;
        this.price = price;
        this.status = status;
    }


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }


}
