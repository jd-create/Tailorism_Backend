package nl.novi.jdemeijervandriel.tailorism.domain;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import java.util.Date;

@Entity
@DiscriminatorValue("2")
public class Labor extends Product{

    private Date startTime;
    private Date endTime;

    public Labor(){}

    public Labor(Date startTime, String name, String description){
        this.startTime = startTime;
        super.name = name;
        super.description = description;

    }

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }
}
