package nl.novi.jdemeijervandriel.tailorism.controller;

import nl.novi.jdemeijervandriel.tailorism.domain.EStatus;
import nl.novi.jdemeijervandriel.tailorism.domain.Product;
import nl.novi.jdemeijervandriel.tailorism.domain.Status;
import nl.novi.jdemeijervandriel.tailorism.repository.ProductRepository;
import nl.novi.jdemeijervandriel.tailorism.repository.StatusRepository;
import nl.novi.jdemeijervandriel.tailorism.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/product")
public class ProductController {

    @Autowired
    private ProductService productService;

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private StatusRepository statusRepository;

    @GetMapping(value = "/list")
    public ResponseEntity<Object> getProducts(){
        List<Product> products = productService.getAllProducts();
        return new ResponseEntity<>(products, HttpStatus.OK);
    }

     @GetMapping(value = "/status/{status}" )
    public ResponseEntity<Object> findProductByStatus(@PathVariable ("status") String name)
     {
         Optional<Product> productByStatus = productRepository.findProductByStatus(name);
         return  new ResponseEntity<>(productByStatus, HttpStatus.OK);
     }
}
