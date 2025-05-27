package co.edu.icesi.pf.infrastructure.drivenadapter.jpa.helpers;

import co.edu.icesi.pf.domain.model.entities.Match;
import co.edu.icesi.pf.infrastructure.drivenadapter.jpa.data.MatchDAO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring", uses = {
        PoolDAOMapper.class,
        TeamDAOMapper.class
})
public interface MatchDAOMapper {

    @Mapping(target = "pool", source = "pool")
    @Mapping(target = "homeTeam", source = "homeTeam")
    @Mapping(target = "visitorTeam", source = "visitorTeam")
    @Mapping(target = "homeTeamGoals", source = "homeGoals")
    @Mapping(target = "visitorTeamGoals", source = "visitorGoals")
    @Mapping(target = "homeTeamYellowCards", source = "homeYellowCards")
    @Mapping(target = "homeTeamRedCards", source = "homeRedCards")
    @Mapping(target = "visitorTeamYellowCards", source = "visitorYellowCards")
    @Mapping(target = "visitorTeamRedCards", source = "visitorRedCards")
    Match toDomain(MatchDAO matchDAO);

    @Mapping(target = "pool", source = "pool")
    @Mapping(target = "homeTeam", source = "homeTeam")
    @Mapping(target = "visitorTeam", source = "visitorTeam")
    @Mapping(target = "homeGoals", source = "homeTeamGoals")
    @Mapping(target = "visitorGoals", source = "visitorTeamGoals")
    @Mapping(target = "homeYellowCards", source = "homeTeamYellowCards")
    @Mapping(target = "homeRedCards", source = "homeTeamRedCards")
    @Mapping(target = "visitorYellowCards", source = "visitorTeamYellowCards")
    @Mapping(target = "visitorRedCards", source = "visitorTeamRedCards")
    MatchDAO toData(Match match);

}
