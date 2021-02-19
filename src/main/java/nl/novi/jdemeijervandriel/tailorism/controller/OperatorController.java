package nl.novi.jdemeijervandriel.tailorism.controller;

import nl.novi.jdemeijervandriel.tailorism.domain.Customer;
import nl.novi.jdemeijervandriel.tailorism.domain.Order;
import nl.novi.jdemeijervandriel.tailorism.domain.Product;
import nl.novi.jdemeijervandriel.tailorism.repository.CustomerRepository;
import nl.novi.jdemeijervandriel.tailorism.repository.RoleRepository;
import nl.novi.jdemeijervandriel.tailorism.service.CustomerService;
import nl.novi.jdemeijervandriel.tailorism.service.OrderService;
import nl.novi.jdemeijervandriel.tailorism.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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


}
