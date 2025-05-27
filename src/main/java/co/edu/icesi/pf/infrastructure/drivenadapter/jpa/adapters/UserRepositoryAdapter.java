package co.edu.icesi.pf.infrastructure.drivenadapter.jpa.adapters;

import co.edu.icesi.pf.domain.model.entities.User;
import co.edu.icesi.pf.domain.model.enums.DomainErrorType;
import co.edu.icesi.pf.domain.model.exceptions.DomainException;
import co.edu.icesi.pf.domain.model.gateways.repository.UserRepository;
import co.edu.icesi.pf.infrastructure.drivenadapter.jpa.helpers.UserDAOMapper;
import co.edu.icesi.pf.infrastructure.drivenadapter.jpa.repositories.UserDAORepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@RequiredArgsConstructor
@Repository
public class UserRepositoryAdapter implements UserRepository {

    private final UserDAORepository userDAORepository;
    private final UserDAOMapper userDAOMapper;

    @Override
    public User findByEmail(String email) {
        var userDAO = userDAORepository.findByEmail(email);
        if (userDAO.isEmpty()) {
            throw new DomainException(DomainErrorType.NOT_FOUND, "User not found by email: " + email);
        }
        return userDAOMapper.toDomain(userDAO.get());
    }

    @Override
    public User findById(String id) {
        var userDAO = userDAORepository.findById(UUID.fromString(id));
        if (userDAO.isEmpty()) {
            throw new DomainException(DomainErrorType.NOT_FOUND, "User not found by id: " + id);
        }
        return userDAOMapper.toDomain(userDAO.get());
    }

    @Override
    public User findByEmailAndPoolId(String email, String poolId) {
        var userDAO = userDAORepository.findByEmailAndPool_Id(email, UUID.fromString(poolId));
        if (userDAO.isEmpty()) {
            throw new DomainException(DomainErrorType.NOT_FOUND, "User not found by email: " + email + " and poolId: " + poolId);
        }
        return userDAOMapper.toDomain(userDAO.get());
    }

    @Override
    public void save(User user) {
        var userDAO = userDAOMapper.toData(user);
        var existingUser = userDAORepository.existsByEmailAndPool_IdAndIdNumber(
                user.getEmail(),
                UUID.fromString(user.getPool().getId()),
                user.getIdNumber()
        );
        if (existingUser) {
            throw new DomainException(DomainErrorType.ALREADY_EXISTS, "User already exists with email: " + user.getEmail());
        }
        userDAORepository.save(userDAO);
    }
}
