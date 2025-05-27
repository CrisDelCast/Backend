package co.edu.icesi.pf.domain.model.entities;

import co.edu.icesi.pf.domain.model.enums.EntityStatus;
import lombok.Builder;
import lombok.Data;

import java.util.Date;

@Data
@Builder
public class Team {

    private String id;
    private Pool pool;
    private String name;
    private String shortName;
    private String flag;
    private int phase;
    private EntityStatus state;
    private Date createdAt;
    private Date updatedAt;

}
