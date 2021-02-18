package nl.novi.jdemeijervandriel.tailorism.domain;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import java.util.Date;

@Entity
@DiscriminatorValue("2")
public class Labor extends Product{

    private String startTime;
    private String endTime;


    public Labor(){}

    public Labor(String startTime, String productName, String description, Status status){
        this.startTime = startTime;
        super.productName = productName;
        super.description = description;
        super.status = status;
    }


    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }
}
