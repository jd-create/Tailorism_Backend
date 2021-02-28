package nl.novi.jdemeijervandriel.tailorism.repository;


import nl.novi.jdemeijervandriel.tailorism.domain.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface ProductRepository extends JpaRepository<Product,Long> {
    Optional<Product> findProductsByStatus(Long status);
}
