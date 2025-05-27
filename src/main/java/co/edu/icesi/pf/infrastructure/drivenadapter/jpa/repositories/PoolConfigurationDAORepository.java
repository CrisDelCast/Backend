package co.edu.icesi.pf.infrastructure.drivenadapter.jpa.repositories;

import co.edu.icesi.pf.infrastructure.drivenadapter.jpa.data.PoolConfigurationDAO;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PoolConfigurationDAORepository extends JpaRepository<PoolConfigurationDAO, String> {
}
