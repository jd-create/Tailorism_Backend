package nl.novi.jdemeijervandriel.tailorism.repository;


import nl.novi.jdemeijervandriel.tailorism.domain.EStatus;
import nl.novi.jdemeijervandriel.tailorism.domain.Status;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface StatusRepository extends JpaRepository<Status, Long> {
    Optional<Status> findByName(EStatus statusName);
}
