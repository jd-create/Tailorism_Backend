package nl.novi.jdemeijervandriel.tailorism.service;

import nl.novi.jdemeijervandriel.tailorism.domain.Address;
import nl.novi.jdemeijervandriel.tailorism.domain.Customer;
import nl.novi.jdemeijervandriel.tailorism.domain.CustomerBuilder;
import nl.novi.jdemeijervandriel.tailorism.exception.DatabaseErrorException;
import nl.novi.jdemeijervandriel.tailorism.exception.RecordNotFoundException;
import nl.novi.jdemeijervandriel.tailorism.payload.request.RegisterCustomerRequest;
import nl.novi.jdemeijervandriel.tailorism.repository.AddressRepository;
import nl.novi.jdemeijervandriel.tailorism.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.naming.NameNotFoundException;
import java.util.List;

@Service
public class CustomerService {

    @Autowired
    CustomerRepository customerRepository;

    @Autowired
    AddressRepository addressRepository;


    public List<Customer> getAllCustomers()
    {
        List<Customer> customers = customerRepository.findAll();
            return customers;
    }

    public Customer getCustomerById(long id){
        if(customerRepository.existsById(id)){
            Customer customer = customerRepository.findById(id).orElse(null);

            return customer;
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

    public long saveCustomer (RegisterCustomerRequest registerCustomerRequest){
        Customer customer = new CustomerBuilder(registerCustomerRequest).buildCustomer();
        Address address = new CustomerBuilder (registerCustomerRequest)
                .buildAddress();

        Address savedAddress = addressRepository.save(address);
        customer.setAddress(savedAddress);
        address.setCustomer(customer);

        return customerRepository.save(customer).getId();
    }

    public void updateCustomer(long id, Customer customer) {
        if(customerRepository.existsById(id)){
            try {
                Customer existingClient = customerRepository.findById(id).orElse(null);
                existingClient.setFirstName(customer.getFirstName());
                existingClient.setLastName(customer.getLastName());
                customerRepository.save(existingClient);
            } catch (Exception e){
                throw new DatabaseErrorException();
            }
        } else {
            throw new RecordNotFoundException();
        }
    }


    public Customer getCustomerByLastName(String lastName) {
        Customer customer = customerRepository.findByLastNameIgnoreCase(lastName);
        return customer;
    }


}
