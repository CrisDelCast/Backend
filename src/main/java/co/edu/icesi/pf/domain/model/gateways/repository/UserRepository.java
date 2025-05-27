package co.edu.icesi.pf.domain.model.gateways.repository;

import co.edu.icesi.pf.domain.model.entities.User;

import java.util.UUID;

public interface UserRepository {

    User findByEmail(String email);

    User findById(String id);

    User findByEmailAndPoolId(String email, String poolId);

    void save(User user);

}
