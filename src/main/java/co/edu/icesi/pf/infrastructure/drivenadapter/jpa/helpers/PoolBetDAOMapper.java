package co.edu.icesi.pf.infrastructure.drivenadapter.jpa.helpers;

import co.edu.icesi.pf.domain.model.entities.PoolBet;
import co.edu.icesi.pf.infrastructure.drivenadapter.jpa.data.PoolBetDAO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring", uses = {
        PoolDAOMapper.class,
        UserDAOMapper.class,
        TeamDAOMapper.class
})
public interface PoolBetDAOMapper {

    @Mapping(target = "pool", source = "pool")
    @Mapping(target = "user", source = "user")
    @Mapping(target = "firstPlaceTeam", source = "firstPlace")
    @Mapping(target = "secondPlaceTeam", source = "secondPlace")
    @Mapping(target = "thirdPlaceTeam", source = "thirdPlace")
    PoolBet toDomain(PoolBetDAO poolBetDAO);

    @Mapping(target = "pool", source = "pool")
    @Mapping(target = "user", source = "user")
    @Mapping(target = "firstPlace", source = "firstPlaceTeam")
    @Mapping(target = "secondPlace", source = "secondPlaceTeam")
    @Mapping(target = "thirdPlace", source = "thirdPlaceTeam")
    PoolBetDAO toData(PoolBet poolBet);

}
