package nl.novi.jdemeijervandriel.tailorism.controller;

import nl.novi.jdemeijervandriel.tailorism.domain.*;
import nl.novi.jdemeijervandriel.tailorism.payload.AddressRequest;
import nl.novi.jdemeijervandriel.tailorism.repository.AddressRepository;
import nl.novi.jdemeijervandriel.tailorism.repository.CustomerDetailsRepository;
import nl.novi.jdemeijervandriel.tailorism.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;


@RestController
@RequestMapping("/api/operator")
public class OperatorController {

    @Autowired
    private CustomerDetailsRepository customerDetailsRepository;

    @Autowired
    private CustomerDetailsService customerDetailsService;

    @Autowired
    private OrderService orderService;

    @Autowired
    private ProductService productService;

    @Autowired
    private AddressRepository addressRepository;

    @GetMapping(value = "/customer/list")
    public ResponseEntity<Object> getCustomers(){
        List<CustomerDetails> customerDetails = customerDetailsService.getAllCustomers();
        return new ResponseEntity<>(customerDetails, HttpStatus.OK);
    }

    @GetMapping(value = "/customer/lastname/{lastname}")
    public ResponseEntity<Object> getCustomerByLastName(@PathVariable("lastname") String lastname){
        CustomerDetails customerDetails = customerDetailsService.getCustomerByLastName(lastname);
        return new ResponseEntity<>(customerDetails, HttpStatus.OK);
    }

    @GetMapping(value = "/customer/id/{id}")
    public ResponseEntity<Object> getCustomer(@PathVariable("id") long id){
        CustomerDetails customerDetails = customerDetailsService.getCustomerById(id);
        return new ResponseEntity<>(customerDetails, HttpStatus.OK);
    }

    @GetMapping(value = "/order/list")
    public ResponseEntity<Object> getAllOrders(){
        List<Order> orderList = orderService.getAllOrders();
        return new ResponseEntity<>(orderList, HttpStatus.OK);
    }

    @GetMapping(value = "/product/list")
    public ResponseEntity<Object>getAllProducts(){
        List<Product> products = productService.getAllProducts();
        return new ResponseEntity<>(products,HttpStatus.OK);
        }

    @GetMapping("/addressbystreetandhousenumber/list")
    public ResponseEntity<Object> findByStreetAndAndHouseNumber(@RequestBody AddressRequest addressRequest){
        List<Address> addressList = addressRepository.findByStreetAndAndHouseNumber(addressRequest.getStreet(),addressRequest.getHouseNumber());
        return new ResponseEntity<>(addressList,HttpStatus.OK);
    }

}
