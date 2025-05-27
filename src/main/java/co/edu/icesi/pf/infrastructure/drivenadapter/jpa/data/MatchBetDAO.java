package co.edu.icesi.pf.infrastructure.drivenadapter.jpa.data;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.Date;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "match_bet")
public class MatchBetDAO {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @ManyToOne
    @JoinColumn(name = "pool_id")
    private PoolDAO pool;

    @ManyToOne
    @JoinColumn(name = "match_id")
    private MatchDAO match;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private UserDAO user;

    @ManyToOne
    @JoinColumn(name = "winner_team_id")
    private TeamDAO winnerTeam;

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

    private Boolean rated;

    private BigDecimal points;

    @Column(nullable = false)
    private String state;

    @Column(name = "created_at", nullable = false, updatable = false)
    private Date createdAt = new Date();

    @Column(name = "updated_at", nullable = false)
    private Date updatedAt = new Date();

}
