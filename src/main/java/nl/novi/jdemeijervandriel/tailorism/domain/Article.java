package nl.novi.jdemeijervandriel.tailorism.domain;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import java.math.BigDecimal;
import java.util.Date;

@Entity
@DiscriminatorValue("1")
public class Article extends Product{

    private Boolean isAvailable;
    private String storageLocation;

    public Article(){

    }
//
    public Article(Boolean isAvailable, String storageLocation, String name, String description, BigDecimal price){
        this.isAvailable = isAvailable;
        this.storageLocation = storageLocation;
        super.name = name;
        super.description = description;
        super.price = price;
    }




    public String getStorageLocation() {
        return storageLocation;
    }

    public void setStorageLocation(String storageLocation) {
        this.storageLocation = storageLocation;
    }

    public Boolean getAvailable() {
        return isAvailable;
    }

    public void setAvailable(Boolean available) {
        isAvailable = available;
    }
}
