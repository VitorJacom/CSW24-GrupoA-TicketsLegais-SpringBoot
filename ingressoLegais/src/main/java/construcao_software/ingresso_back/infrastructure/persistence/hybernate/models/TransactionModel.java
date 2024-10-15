package construcao_software.ingresso_back.infrastructure.persistence.hybernate.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "transaction")
public class TransactionModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "transaction_id")
    private Long transactionId;

    @ManyToOne
    @JoinColumn(name = "tenant_id", nullable = false)
    private TenantModel tenant;

    @ManyToOne
    @JoinColumn(name = "buyer_id")
    private UserModel buyer;

    @OneToOne
    @JoinColumn(name = "ticket_id", nullable = false)
    private TicketModel ticket;

    @Column(nullable = false)
    private Double sellingPrice;

    @Column(nullable = false)
    private LocalDateTime transactionDate;

    @Column(nullable = false)
    private String transactionStatus;
}
