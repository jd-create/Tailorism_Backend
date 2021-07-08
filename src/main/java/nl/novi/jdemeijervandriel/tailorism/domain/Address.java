package nl.novi.jdemeijervandriel.tailorism.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;


import javax.persistence.*;
@Entity
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    @Column(columnDefinition = "serial")
    private long id;
    private String street;
    private String houseNumber;
    private String postcode;
    private String city;

    @JsonIgnore
    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL,orphanRemoval = true)
    @JoinColumn(name ="id")
    private CustomerDetails customerDetails;


    public Address(){}

    public Address(String street, String houseNumber, String postCode, String city){
        this.street = street;
        this.houseNumber = houseNumber;
        this.postcode = postCode;
        this.city = city;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getHouseNumber() {
        return houseNumber;
    }

    public void setHouseNumber(String houseNumber) {
        this.houseNumber = houseNumber;
    }

    public String getPostcode() {
        return postcode;
    }

    public void setPostCode(String postCode) {
        this.postcode = postCode;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void setCustomer(CustomerDetails customerDetails) {
    }
}
