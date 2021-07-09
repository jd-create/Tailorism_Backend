package nl.novi.jdemeijervandriel.tailorism.service;

import nl.novi.jdemeijervandriel.tailorism.domain.Address;
import nl.novi.jdemeijervandriel.tailorism.domain.CustomerDetails;
import nl.novi.jdemeijervandriel.tailorism.domain.CustomerBuilder;
import nl.novi.jdemeijervandriel.tailorism.exception.DatabaseErrorException;
import nl.novi.jdemeijervandriel.tailorism.exception.RecordNotFoundException;
import nl.novi.jdemeijervandriel.tailorism.payload.RegisterUserRequest;
import nl.novi.jdemeijervandriel.tailorism.repository.AddressRepository;
import nl.novi.jdemeijervandriel.tailorism.repository.CustomerDetailsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerDetailsService {

    @Autowired
    CustomerDetailsRepository customerDetailsRepository;

    @Autowired
    AddressRepository addressRepository;

    public List<CustomerDetails> getAllCustomers()
    {
        List<CustomerDetails> customerDetails = customerDetailsRepository.findAll();
            return customerDetails;
    }

    public CustomerDetails getCustomerById(long id){
        if(customerDetailsRepository.existsById(id)){
            CustomerDetails customerDetails = customerDetailsRepository.findById(id).orElse(null);

            return customerDetails;
        }else {
            throw new RecordNotFoundException();
        }
    }

    public void deleteCustomer(long id) {
        if (customerDetailsRepository.existsById(id)){
            customerDetailsRepository.deleteById(id);
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

        return customerDetailsRepository.save(customerDetails).getId();
    }

    public void updateCustomer(long id, CustomerDetails customerDetails) {
        if(customerDetailsRepository.existsById(id)){
            try {
                CustomerDetails existingClient = customerDetailsRepository.findById(id).orElse(null);
                existingClient.setFirstName(customerDetails.getFirstName());
                existingClient.setLastName(customerDetails.getLastName());
                customerDetailsRepository.save(existingClient);
            } catch (Exception e){
                throw new DatabaseErrorException();
            }
        } else {
            throw new RecordNotFoundException();
        }
    }


    public CustomerDetails getCustomerByLastName(String lastName) {
        CustomerDetails customerDetails = customerDetailsRepository.findByLastNameIgnoreCase(lastName);
        return customerDetails;
    }


}
