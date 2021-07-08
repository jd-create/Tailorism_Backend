package nl.novi.jdemeijervandriel.tailorism.domain;

import nl.novi.jdemeijervandriel.tailorism.payload.RegisterUserRequest;

public class CustomerBuilder {

    private String firstName;
    private String lastName;
    private String telephoneNumber;
    private String bankAccount;
    private String street;
    private String houseNumber;
    private String postcode;
    private String city;

    public CustomerBuilder(RegisterUserRequest registerUserRequest){
        this.firstName = registerUserRequest.getFirstName();
        this.lastName = registerUserRequest.getLastName();
        this.telephoneNumber = registerUserRequest.getPhoneNumber();
        this.bankAccount = registerUserRequest.getBankAccount();
        this.street = registerUserRequest.getStreet();
        this.houseNumber = registerUserRequest.getHouseNumber();
        this.postcode = registerUserRequest.getPostcode();
        this.city = registerUserRequest.getCity();
    }

    public CustomerDetails buildCustomer(){
        return new CustomerDetails(firstName, lastName,telephoneNumber, bankAccount);
    }

    public Address buildAddress(){
        return new Address(street, houseNumber, postcode, city);
    }
}
