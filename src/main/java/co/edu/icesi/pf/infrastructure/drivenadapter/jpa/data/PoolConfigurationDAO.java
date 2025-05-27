package co.edu.icesi.pf.infrastructure.drivenadapter.jpa.data;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "pool_configuration")
public class PoolConfigurationDAO {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @OneToOne
    @JoinColumn(name = "pool_id", unique = true)
    private PoolDAO pool;

    @Column(name = "champions_win_points", nullable = false)
    private BigDecimal championsWinPoints;

    @Column(name = "second_place_win_points", nullable = false)
    private BigDecimal secondPlaceWinPoints;

    @Column(name = "third_place_win_points", nullable = false)
    private BigDecimal thirdPlaceWinPoints;

    @Column(name = "winner_team_win_points", nullable = false)
    private BigDecimal winnerTeamWinPoints;

    @Column(name = "draw_team_win_points", nullable = false)
    private BigDecimal drawTeamWinPoints;

    @Column(name = "total_yellow_cards_win_points", nullable = false)
    private BigDecimal totalYellowCardsWinPoints;

    @Column(name = "total_red_cards_win_points", nullable = false)
    private BigDecimal totalRedCardsWinPoints;

    @Column(name = "total_local_goals_win_points", nullable = false)
    private BigDecimal totalLocalGoalsWinPoints;

    @Column(name = "total_visiting_goal_win_points", nullable = false)
    private BigDecimal totalVisitingGoalWinPoints;

}
