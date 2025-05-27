package co.edu.icesi.pf.infrastructure.drivenadapter.jpa.repositories;

import co.edu.icesi.pf.infrastructure.drivenadapter.jpa.data.PoolDAO;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PoolDAORepository extends JpaRepository<PoolDAO, String> {
}
