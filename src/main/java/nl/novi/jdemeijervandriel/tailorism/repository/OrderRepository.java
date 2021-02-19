package nl.novi.jdemeijervandriel.tailorism.repository;

import nl.novi.jdemeijervandriel.tailorism.domain.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Long> {

}
