package co.edu.icesi.pf.domain.model.entities;

import co.edu.icesi.pf.domain.model.enums.EntityStatus;
import lombok.Builder;
import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
@Builder
public class Pool {

    private String id;
    private String name;
    private PoolConfiguration configuration;
    private Date startingDate;
    private Date endingDate;
    private int phase;
    private EntityStatus state;
    private Date createdAt;
    private Date updatedAt;

}
