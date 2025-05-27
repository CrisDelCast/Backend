package co.edu.icesi.pf.infrastructure.drivenadapter.jpa.helpers;

import co.edu.icesi.pf.domain.model.entities.PoolConfiguration;
import co.edu.icesi.pf.infrastructure.drivenadapter.jpa.data.PoolConfigurationDAO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring", uses = {
})
public interface PoolConfigurationDAOMapper {

    @Mapping(target = "championPlacePoints", source = "championsWinPoints")
    @Mapping(target = "secondPlacePoints", source = "secondPlaceWinPoints")
    @Mapping(target = "thirdPlacePoints", source = "thirdPlaceWinPoints")
    @Mapping(target = "winnerTeamPoints", source = "winnerTeamWinPoints")
    @Mapping(target = "drawTeamPoints", source = "drawTeamWinPoints")
    @Mapping(target = "totalYellowCardsPoints", source = "totalYellowCardsWinPoints")
    @Mapping(target = "totalRedCardsPoints", source = "totalRedCardsWinPoints")
    @Mapping(target = "totalLocalGoalsPoints", source = "totalLocalGoalsWinPoints")
    @Mapping(target = "totalVisitorGoalsPoints", source = "totalVisitingGoalWinPoints")
    PoolConfiguration toDomain(PoolConfigurationDAO poolConfigurationDAO);

    @Mapping(target = "championsWinPoints", source = "championPlacePoints")
    @Mapping(target = "secondPlaceWinPoints", source = "secondPlacePoints")
    @Mapping(target = "thirdPlaceWinPoints", source = "thirdPlacePoints")
    @Mapping(target = "winnerTeamWinPoints", source = "winnerTeamPoints")
    @Mapping(target = "drawTeamWinPoints", source = "drawTeamPoints")
    @Mapping(target = "totalYellowCardsWinPoints", source = "totalYellowCardsPoints")
    @Mapping(target = "totalRedCardsWinPoints", source = "totalRedCardsPoints")
    @Mapping(target = "totalLocalGoalsWinPoints", source = "totalLocalGoalsPoints")
    @Mapping(target = "totalVisitingGoalWinPoints", source = "totalVisitorGoalsPoints")
    PoolConfigurationDAO toData(PoolConfiguration poolConfiguration);

}
