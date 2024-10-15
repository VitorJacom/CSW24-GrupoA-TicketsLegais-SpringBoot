package construcao_software.ingresso_back.infrastructure.persistence.hybernate.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "ticket")
public class TicketModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ticket_id")
    private Long ticketId;

    @ManyToOne
    @JoinColumn(name = "event_id", nullable = false)
    private EventModel event;

    @ManyToOne
    @JoinColumn(name = "tenant_id", nullable = false)
    private TenantModel tenant;

    @Column(nullable = false)
    private Double originalPrice;

    @ManyToOne
    @JoinColumn(name = "seller_id")
    private UserModel seller;

    @Column(nullable = false, unique = true)
    private String uniqueVerificationCode;

    @Column(nullable = false)
    private String status;
}
