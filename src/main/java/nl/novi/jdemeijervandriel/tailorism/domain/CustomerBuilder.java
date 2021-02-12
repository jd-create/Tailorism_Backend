package nl.novi.jdemeijervandriel.tailorism.domain;

import nl.novi.jdemeijervandriel.tailorism.payload.request.RegisterCustomerRequest;

public class CustomerBuilder {

    private String firstName;
    private String lastName;
    private String street;
    private String houseNumber;
    private String postcode;
    private String city;

    public CustomerBuilder(RegisterCustomerRequest registerCustomerRequest){
        this.firstName = registerCustomerRequest.getFirstName();
        this.lastName = registerCustomerRequest.getLastName();
        this.street = registerCustomerRequest.getStreet();
        this.houseNumber = registerCustomerRequest.getHouseNumber();
        this.postcode = registerCustomerRequest.getPostcode();
        this.city = registerCustomerRequest.getCity();
    }

    public Customer buildCustomer(){
        return new Customer (firstName, lastName);
    }

    public Address buildAddress(){
        return new Address(street, houseNumber, postcode, city);
    }
}
