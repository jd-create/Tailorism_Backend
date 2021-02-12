package nl.novi.jdemeijervandriel.tailorism.repository;

import nl.novi.jdemeijervandriel.tailorism.domain.Address;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AddressRepository extends JpaRepository<Address, Long> {
}
