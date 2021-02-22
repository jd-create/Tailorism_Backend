package nl.novi.jdemeijervandriel.tailorism.repository;

import nl.novi.jdemeijervandriel.tailorism.domain.File;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FileRepository extends JpaRepository<File, String> {

    boolean existsByCustomer_Id(long id);
    File findByCustomer_Id(long id);
}
