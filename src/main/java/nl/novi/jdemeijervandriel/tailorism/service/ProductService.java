package nl.novi.jdemeijervandriel.tailorism.service;

import nl.novi.jdemeijervandriel.tailorism.domain.EStatus;
import nl.novi.jdemeijervandriel.tailorism.domain.Product;
import nl.novi.jdemeijervandriel.tailorism.domain.Status;
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

   /* public Long compareIncomingStringToEnumIndex(String status)
    {
        long status_long = -1;
        EStatus[] allStatusPosibilities = EStatus.values();


        for (int i = 0; i < 5; i++)
        {EStatus[] allStatusPosibilities
            int y;
            y =i;
        }
        return y;
    }

}

/*    for (EStatus x : allStatusPosibilities) {
            if (x.toString().equals(status)) {

                return (Long)x + 1;
            }*/
}


