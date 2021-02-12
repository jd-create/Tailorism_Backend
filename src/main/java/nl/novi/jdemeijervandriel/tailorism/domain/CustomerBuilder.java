package nl.novi.jdemeijervandriel.tailorism.domain;

import nl.novi.jdemeijervandriel.tailorism.payload.request.RegisterUserRequest;

public class CustomerBuilder {

    private String firstName;
    private String lastName;
    private String street;
    private String houseNumber;
    private String postcode;
    private String city;

    public CustomerBuilder(RegisterUserRequest registerUserRequest){
        this.firstName = registerUserRequest.getFirstName();
        this.lastName = registerUserRequest.getLastName();
        this.street = registerUserRequest.getStreet();
        this.houseNumber = registerUserRequest.getHouseNumber();
        this.postcode = registerUserRequest.getPostcode();
        this.city = registerUserRequest.getCity();
    }

    public Customer buildCustomer(){
        return new Customer (firstName, lastName);
    }

    public Address buildAddress(){
        return new Address(street, houseNumber, postcode, city);
    }
}
