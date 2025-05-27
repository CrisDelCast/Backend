package co.edu.icesi.pf.infrastructure.drivenadapter.jpa.data;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "pool")
public class PoolDAO {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(nullable = false)
    private String name;

    @OneToOne
    @JoinColumn(name = "configuration_id")
    private PoolConfigurationDAO configuration;

    @Column(name = "starting_date", nullable = false)
    private Date startingDate;

    @Column(name = "ending_date", nullable = false)
    private Date endingDate;

    private Integer phase;

    @Column(nullable = false)
    private String state;

    @Column(name = "created_at", nullable = false, updatable = false)
    private Date createdAt = new Date();

    @Column(name = "updated_at", nullable = false)
    private Date updatedAt = new Date();


    @OneToMany(mappedBy = "pool", cascade = CascadeType.ALL)
    private List<TeamDAO> teams;

    @OneToMany(mappedBy = "pool", cascade = CascadeType.ALL)
    private List<MatchDAO> matches;

}

