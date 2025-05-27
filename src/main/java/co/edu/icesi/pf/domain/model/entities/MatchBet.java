package co.edu.icesi.pf.domain.model.entities;

import co.edu.icesi.pf.domain.model.enums.EntityStatus;
import lombok.Builder;
import lombok.Data;

import java.util.Date;

@Data
@Builder
public class MatchBet {

    private String id;
    private Pool pool;
    private Match match;
    private User user;
    private Team winnerTeam;
    private int homeTeamGoals;
    private int visitorTeamGoals;
    private int homeTeamYellowCards;
    private int homeTeamRedCards;
    private int visitorTeamYellowCards;
    private int visitorTeamRedCards;
    private boolean rated;
    private Double points;
    private EntityStatus state;
    private Date createdAt;
    private Date updatedAt;

}
