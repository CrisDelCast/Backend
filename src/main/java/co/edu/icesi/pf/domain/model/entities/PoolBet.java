package co.edu.icesi.pf.domain.model.entities;

import co.edu.icesi.pf.domain.model.enums.EntityStatus;
import lombok.Builder;
import lombok.Data;

import java.util.Date;

@Data
@Builder
public class PoolBet {

    private String id;
    private Pool pool;
    private User user;
    private Team firstPlaceTeam;
    private Team secondPlaceTeam;
    private Team thirdPlaceTeam;
    private boolean rated;
    private Double points;
    private EntityStatus state;
    private Date createdAt;
    private Date updatedAt;

}
