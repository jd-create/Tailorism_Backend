package nl.novi.jdemeijervandriel.tailorism.repository;

import nl.novi.jdemeijervandriel.tailorism.domain.Address;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;
import java.util.Optional;

public interface AddressRepository extends JpaRepository<Address, Long> {
    List<Address> findByStreetAndAndHouseNumber(String street, String houseNumber);
    Optional<Address> findAddressByCustomerDetails_LastName(String lastname);
}
