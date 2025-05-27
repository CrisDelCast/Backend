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
@Table(name = "team")
public class TeamDAO {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @ManyToOne
    @JoinColumn(name = "pool_id")
    private PoolDAO pool;

    @Column(nullable = false)
    private String name;

    @Column(name = "short_name")
    private String shortName;

    private String flag;

    private Integer phase;

    @Column(nullable = false)
    private String state;

    @Column(name = "created_at", nullable = false, updatable = false)
    private Date createdAt = new Date();

    @Column(name = "updated_at", nullable = false)
    private Date updatedAt = new Date();


    @OneToMany(mappedBy = "homeTeam", cascade = CascadeType.ALL)
    private List<MatchDAO> homeMatches;

    @OneToMany(mappedBy = "visitorTeam", cascade = CascadeType.ALL)
    private List<MatchDAO> visitorMatches;

}
