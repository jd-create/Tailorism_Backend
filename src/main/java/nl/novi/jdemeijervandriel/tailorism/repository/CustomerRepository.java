package nl.novi.jdemeijervandriel.tailorism.repository;

import nl.novi.jdemeijervandriel.tailorism.domain.CustomerDetails;
import org.springframework.data.jpa.repository.JpaRepository;



public interface CustomerRepository extends JpaRepository<CustomerDetails, Long> {

    public CustomerDetails findByLastNameIgnoreCase(String lastName);
}
