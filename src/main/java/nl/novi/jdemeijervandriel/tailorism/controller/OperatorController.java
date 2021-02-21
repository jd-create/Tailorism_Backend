package nl.novi.jdemeijervandriel.tailorism.controller;

import nl.novi.jdemeijervandriel.tailorism.domain.*;
import nl.novi.jdemeijervandriel.tailorism.payload.request.AddressRequest;
import nl.novi.jdemeijervandriel.tailorism.payload.request.RoleRequest;
import nl.novi.jdemeijervandriel.tailorism.repository.AddressRepository;
import nl.novi.jdemeijervandriel.tailorism.repository.CustomerRepository;
import nl.novi.jdemeijervandriel.tailorism.repository.RoleRepository;
import nl.novi.jdemeijervandriel.tailorism.repository.UserRepository;
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
    private CustomerRepository customerRepository;

    @Autowired
    private CustomerService customerService;

    @Autowired
    private OrderService orderService;

    @Autowired
    private ProductService productService;

    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private AddressRepository addressRepository;

    @Autowired
    private UserDetailsServiceImpl userDetailsService;

    @GetMapping(value = "/customer/list")
    public ResponseEntity<Object> getCustomers(){
        List<Customer> customers = customerService.getAllCustomers();
        return new ResponseEntity<>(customers, HttpStatus.OK);
    }

    @GetMapping(value = "/customer/lastname/{lastname}")
    public ResponseEntity<Object> getCustomerByLastName(@PathVariable("lastname") String lastname){
        Customer customer = customerService.getCustomerByLastName(lastname);
        return new ResponseEntity<>(customer, HttpStatus.OK);
    }

    @GetMapping(value = "/customer/id/{id}")
    public ResponseEntity<Object> getCustomer(@PathVariable("id") long id){
        Customer customer = customerService.getCustomerById(id);
        return new ResponseEntity<>(customer, HttpStatus.OK);
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

    /*@GetMapping(value = "/user/{email}/{username}/list")
    public ResponseEntity<Object> findByUsernameAndRoles(@RequestBody RoleRequest roleRequest){
        List<User> userWithRoleCustomer = userRepository.findByUsernameAndRoles(roleRequest.getUsername(),role);
            return new ResponseEntity<>(userWithRoleCustomer,HttpStatus.OK);
        }
    }
    */

    @GetMapping("/addressbystreetandhousenumber/list")
    public ResponseEntity<Object> findByStreetAndAndHouseNumber(@RequestBody AddressRequest addressRequest){
        List<Address> addressList = addressRepository.findByStreetAndAndHouseNumber(addressRequest.getStreet(),addressRequest.getHouseNumber());
        return new ResponseEntity<>(addressList,HttpStatus.OK);
    }

}
