package nl.novi.jdemeijervandriel.tailorism.domain;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import java.math.BigDecimal;
import java.util.Date;

@Entity
@DiscriminatorValue("1")
public class Article extends Product{

    private String storageLocation;

    public Article(){

    }
//
    public Article(String storageLocation, String productName, String description, BigDecimal price, Status status){
        this.storageLocation = storageLocation;
        super.productName = productName;
        super.description = description;
        super.price = price;
        super.status = status;
    }




    public String getStorageLocation() {
        return storageLocation;
    }

    public void setStorageLocation(String storageLocation) {
        this.storageLocation = storageLocation;
    }

}
