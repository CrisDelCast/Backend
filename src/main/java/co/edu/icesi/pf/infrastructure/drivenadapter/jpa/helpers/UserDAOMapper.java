package co.edu.icesi.pf.infrastructure.drivenadapter.jpa.helpers;

import co.edu.icesi.pf.domain.model.entities.User;
import co.edu.icesi.pf.infrastructure.drivenadapter.jpa.data.UserDAO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring", uses = {
        PoolDAOMapper.class,
})
public interface UserDAOMapper {

    @Mapping(target = "pool", source = "pool")
    User toDomain(UserDAO userDAO);

    @Mapping(target = "pool", source = "pool")
    UserDAO toData(User user);

}
