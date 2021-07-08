package nl.novi.jdemeijervandriel.tailorism.service;

import nl.novi.jdemeijervandriel.tailorism.domain.Address;
import nl.novi.jdemeijervandriel.tailorism.domain.CustomerDetails;
import nl.novi.jdemeijervandriel.tailorism.domain.CustomerBuilder;
import nl.novi.jdemeijervandriel.tailorism.exception.DatabaseErrorException;
import nl.novi.jdemeijervandriel.tailorism.exception.RecordNotFoundException;
import nl.novi.jdemeijervandriel.tailorism.payload.RegisterUserRequest;
import nl.novi.jdemeijervandriel.tailorism.repository.AddressRepository;
import nl.novi.jdemeijervandriel.tailorism.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerService {

    @Autowired
    CustomerRepository customerRepository;

    @Autowired
    AddressRepository addressRepository;

    public List<CustomerDetails> getAllCustomers()
    {
        List<CustomerDetails> customerDetails = customerRepository.findAll();
            return customerDetails;
    }

    public CustomerDetails getCustomerById(long id){
        if(customerRepository.existsById(id)){
            CustomerDetails customerDetails = customerRepository.findById(id).orElse(null);

            return customerDetails;
        }else {
            throw new RecordNotFoundException();
        }
    }

    public void deleteCustomer(long id) {
        if (customerRepository.existsById(id)){
            customerRepository.deleteById(id);
        } else {
            throw new RecordNotFoundException();
        }
    }

    public long saveCustomer (RegisterUserRequest registerUserRequest){
        CustomerDetails customerDetails = new CustomerBuilder(registerUserRequest).buildCustomer();
        Address address = new CustomerBuilder (registerUserRequest)
                .buildAddress();

        Address savedAddress = addressRepository.save(address);
        customerDetails.setAddress(savedAddress);
        address.setCustomer(customerDetails);

        return customerRepository.save(customerDetails).getId();
    }

    public void updateCustomer(long id, CustomerDetails customerDetails) {
        if(customerRepository.existsById(id)){
            try {
                CustomerDetails existingClient = customerRepository.findById(id).orElse(null);
                existingClient.setFirstName(customerDetails.getFirstName());
                existingClient.setLastName(customerDetails.getLastName());
                customerRepository.save(existingClient);
            } catch (Exception e){
                throw new DatabaseErrorException();
            }
        } else {
            throw new RecordNotFoundException();
        }
    }


    public CustomerDetails getCustomerByLastName(String lastName) {
        CustomerDetails customerDetails = customerRepository.findByLastNameIgnoreCase(lastName);
        return customerDetails;
    }


}
