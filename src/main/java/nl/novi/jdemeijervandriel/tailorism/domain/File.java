package nl.novi.jdemeijervandriel.tailorism.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Entity
public class File {
    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    private String  id;
    private String name;
    private String type;

    @JsonIgnore
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "customerdetails_id", referencedColumnName = "id")
    private CustomerDetails customerDetails;

    @JsonIgnore
    @Lob
    private byte[] data;

    public File(){}

    public File(String name, String type, byte[] data){
        this.name = name;
        this.type = type;
        this.data = data;
    }

    public File(String originalFilename) {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public CustomerDetails getCustomer() {
        return customerDetails;
    }

    public void setCustomer(CustomerDetails customerDetails) {
        this.customerDetails = customerDetails;
    }

    public byte[] getData() {
        return data;
    }

    public void setData(byte[] data) {
        this.data = data;
    }
}
