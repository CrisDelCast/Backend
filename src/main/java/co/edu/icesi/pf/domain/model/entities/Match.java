package co.edu.icesi.pf.domain.model.entities;

import co.edu.icesi.pf.domain.model.enums.EntityStatus;
import lombok.Builder;
import lombok.Data;

import java.util.Date;

@Data
@Builder
public class Match {

    private String id;
    private Pool pool;
    private Team homeTeam;
    private Team visitorTeam;
    private Date matchDate;
    private int homeTeamGoals;
    private int visitorTeamGoals;
    private int homeTeamYellowCards;
    private int homeTeamRedCards;
    private int visitorTeamYellowCards;
    private int visitorTeamRedCards;
    private int phase;
    private EntityStatus state;
    private Date createdAt;
    private Date updatedAt;

}
