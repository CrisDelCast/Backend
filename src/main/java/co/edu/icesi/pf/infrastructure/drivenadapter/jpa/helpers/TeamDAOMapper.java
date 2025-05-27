package co.edu.icesi.pf.infrastructure.drivenadapter.jpa.helpers;

import co.edu.icesi.pf.domain.model.entities.Team;
import co.edu.icesi.pf.infrastructure.drivenadapter.jpa.data.TeamDAO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring", uses = {
        PoolDAOMapper.class,
})
public interface TeamDAOMapper {

    @Mapping(target = "pool", source = "pool")
    Team toDomain(TeamDAO teamDAO);

    @Mapping(target = "pool", source = "pool")
    TeamDAO toData(Team team);

}
