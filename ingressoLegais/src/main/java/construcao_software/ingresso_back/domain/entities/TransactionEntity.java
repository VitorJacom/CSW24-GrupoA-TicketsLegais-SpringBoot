package construcao_software.ingresso_back.domain.entities;

import construcao_software.ingresso_back.domain.base.TransactionStatus;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class TransactionEntity {
    private Long transactionId;
    private TenantEntity tenant;
    private UserEntity buyer;
    private TicketEntity ticket;
    private Double sellingPrice;
    private LocalDateTime transactionDate;
    private TransactionStatus transactionStatus;
}
