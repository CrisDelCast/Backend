package co.edu.icesi.pf.infrastructure.drivenadapter.jpa.repositories;

import co.edu.icesi.pf.infrastructure.drivenadapter.jpa.data.MatchDAO;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MatchDAORepository extends JpaRepository<MatchDAO, String> {
}
