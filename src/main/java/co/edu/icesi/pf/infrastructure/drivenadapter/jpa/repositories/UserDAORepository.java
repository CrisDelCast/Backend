package co.edu.icesi.pf.infrastructure.drivenadapter.jpa.repositories;

import co.edu.icesi.pf.infrastructure.drivenadapter.jpa.data.UserDAO;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface UserDAORepository extends JpaRepository<UserDAO, String> {

    Optional<UserDAO> findByEmail(String email);

    Optional<UserDAO> findById(UUID id);

    Optional<UserDAO> findByEmailAndPool_Id(String email, UUID poolId);

    boolean existsByEmailAndPool_IdAndIdNumber(String email, UUID poolId, String idNumber);

}
