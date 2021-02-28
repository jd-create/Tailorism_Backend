package nl.novi.jdemeijervandriel.tailorism.service;

import nl.novi.jdemeijervandriel.tailorism.domain.Product;
import nl.novi.jdemeijervandriel.tailorism.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class ProductService
{

    @Autowired
    ProductRepository productRepository;

    public List<Product> getAllProducts()
    {
        List<Product> products = productRepository.findAll();
        return products;
    }
}


