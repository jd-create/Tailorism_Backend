package nl.novi.jdemeijervandriel.tailorism.repository;

import nl.novi.jdemeijervandriel.tailorism.domain.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
}
