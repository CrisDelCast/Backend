package co.edu.icesi.pf.infrastructure.drivenadapter.jpa.helpers;

import co.edu.icesi.pf.domain.model.entities.Pool;
import co.edu.icesi.pf.infrastructure.drivenadapter.jpa.data.PoolDAO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring", uses = {
        PoolConfigurationDAOMapper.class,
})
public interface PoolDAOMapper {

    @Mapping(target = "configuration", source = "configuration")
    Pool toDomain(PoolDAO poolDAO);

    @Mapping(target = "configuration", source = "configuration")
    PoolDAO toData(Pool pool);

}
