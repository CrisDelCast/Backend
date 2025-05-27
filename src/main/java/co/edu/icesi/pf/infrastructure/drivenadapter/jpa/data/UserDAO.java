package co.edu.icesi.pf.infrastructure.drivenadapter.jpa.data;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "\"user\"") // User es palabra reservada - NO CAMBIAR
public class UserDAO {

    @Id()
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @ManyToOne
    @JoinColumn(name = "pool_id")
    private PoolDAO pool;

    @Column(name = "id_number", nullable = false)
    private String idNumber;

    @Column(nullable = false)
    private String email;

    private String phone;

    private Integer age;

    private String name;

    private String nickname;

    private String password;

    private String photo;

    private String role;

    private String otp;

    private BigDecimal points;

    @Column(nullable = false)
    private String state;

    @Column(name = "created_at", nullable = false, updatable = false)
    private Date createdAt = new Date();

    @Column(name = "updated_at", nullable = false)
    private Date updatedAt = new Date();


    @OneToOne(mappedBy = "user", cascade = CascadeType.ALL)
    private PoolBetDAO poolBet;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<MatchBetDAO> matchBets;

}
