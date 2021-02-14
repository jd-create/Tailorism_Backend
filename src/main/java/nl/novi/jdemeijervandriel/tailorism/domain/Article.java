package nl.novi.jdemeijervandriel.tailorism.domain;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import java.math.BigDecimal;
import java.util.Date;

@Entity
@DiscriminatorValue("1")
public class Article extends Product{

    private Date availability;
    private String storageLocation;

    public Article(){

    }
//
    public Article(Date availability, String storageLocation, String name, String description, BigDecimal price){
        this.availability = availability;
        this.storageLocation = storageLocation;
        super.name = name;
        super.description = description;
        super.price = price;
    }


    public Date getAvailability() {
        return availability;
    }

    public void setAvailability(Date availability) {
        this.availability = availability;
    }

    public String getStorageLocation() {
        return storageLocation;
    }

    public void setStorageLocation(String storageLocation) {
        this.storageLocation = storageLocation;
    }
}
