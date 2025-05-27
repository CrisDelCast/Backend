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
@Table(name = "pool_bet")
public class PoolBetDAO {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @ManyToOne
    @JoinColumn(name = "pool_id")
    private PoolDAO pool;

    @OneToOne
    @JoinColumn(name = "user_id")
    private UserDAO user;

    @ManyToOne
    @JoinColumn(name = "first_place", nullable = false)
    private TeamDAO firstPlace;

    @ManyToOne
    @JoinColumn(name = "second_place")
    private TeamDAO secondPlace;

    @ManyToOne
    @JoinColumn(name = "third_place")
    private TeamDAO thirdPlace;

    private Boolean rated;

    private BigDecimal points;

    @Column(nullable = false)
    private String state;

    @Column(name = "created_at", nullable = false, updatable = false)
    private Date createdAt = new Date();

    @Column(name = "updated_at", nullable = false)
    private Date updatedAt = new Date();

}
