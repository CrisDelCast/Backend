package co.edu.icesi.pf.infrastructure.drivenadapter.jpa.data;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "match")
public class MatchDAO {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @ManyToOne
    @JoinColumn(name = "pool_id")
    private PoolDAO pool;

    @ManyToOne
    @JoinColumn(name = "home_team")
    private TeamDAO homeTeam;

    @ManyToOne
    @JoinColumn(name = "visitor_team")
    private TeamDAO visitorTeam;

    @Column(name = "match_date", nullable = false)
    private Date matchDate;

    @Column(name = "home_goals")
    private Integer homeGoals;

    @Column(name = "visitor_goals")
    private Integer visitorGoals;

    @Column(name = "home_yellow_cards")
    private Integer homeYellowCards;

    @Column(name = "home_red_cards")
    private Integer homeRedCards;

    @Column(name = "visitor_yellow_cards")
    private Integer visitorYellowCards;

    @Column(name = "visitor_red_cards")
    private Integer visitorRedCards;

    private Integer phase;

    @Column(nullable = false)
    private String state;

    @Column(name = "created_at", nullable = false, updatable = false)
    private Date createdAt = new Date();

    @Column(name = "updated_at", nullable = false)
    private Date updatedAt = new Date();

}
