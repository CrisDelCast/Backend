package co.edu.icesi.pf.infrastructure.drivenadapter.jpa.repositories;

import co.edu.icesi.pf.infrastructure.drivenadapter.jpa.data.TeamDAO;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TeamDAORepository extends JpaRepository<TeamDAO, String> {
}
