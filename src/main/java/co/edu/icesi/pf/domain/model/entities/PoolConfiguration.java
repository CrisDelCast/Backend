package co.edu.icesi.pf.domain.model.entities;

import co.edu.icesi.pf.domain.model.enums.EntityStatus;
import lombok.Builder;
import lombok.Data;

import java.util.Date;

@Data
@Builder
public class PoolConfiguration {

    private String id;
    private Double championPlacePoints;
    private Double secondPlacePoints;
    private Double thirdPlacePoints;
    private Double winnerTeamPoints;
    private Double drawTeamPoints;
    private Double totalYellowCardsPoints;
    private Double totalRedCardsPoints;
    private Double totalLocalGoalsPoints;
    private Double totalVisitorGoalsPoints;
    private EntityStatus state;
    private Date createdAt;
    private Date updatedAt;

}
