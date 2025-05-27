package co.edu.icesi.pf.infrastructure.drivenadapter.jpa.helpers;

import co.edu.icesi.pf.domain.model.entities.MatchBet;
import co.edu.icesi.pf.infrastructure.drivenadapter.jpa.data.MatchBetDAO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring", uses = {
        PoolDAOMapper.class,
        MatchDAOMapper.class,
        UserDAOMapper.class,
        TeamDAOMapper.class
})
public interface MatchBetDAOMapper {

    @Mapping(target = "pool", source = "pool")
    @Mapping(target = "match", source = "match")
    @Mapping(target = "user", source = "user")
    @Mapping(target = "winnerTeam", source = "winnerTeam")
    @Mapping(target = "homeTeamGoals", source = "homeGoals")
    @Mapping(target = "visitorTeamGoals", source = "visitorGoals")
    @Mapping(target = "homeTeamYellowCards", source = "homeYellowCards")
    @Mapping(target = "homeTeamRedCards", source = "homeRedCards")
    @Mapping(target = "visitorTeamYellowCards", source = "visitorYellowCards")
    @Mapping(target = "visitorTeamRedCards", source = "visitorRedCards")
    MatchBet toDomain(MatchBetDAO matchBetDAO);

    @Mapping(target = "pool", source = "pool")
    @Mapping(target = "match", source = "match")
    @Mapping(target = "user", source = "user")
    @Mapping(target = "winnerTeam", source = "winnerTeam")
    @Mapping(target = "homeGoals", source = "homeTeamGoals")
    @Mapping(target = "visitorGoals", source = "visitorTeamGoals")
    @Mapping(target = "homeYellowCards", source = "homeTeamYellowCards")
    @Mapping(target = "homeRedCards", source = "homeTeamRedCards")
    @Mapping(target = "visitorYellowCards", source = "visitorTeamYellowCards")
    @Mapping(target = "visitorRedCards", source = "visitorTeamRedCards")
    MatchBetDAO toData(MatchBet matchBet);

}
