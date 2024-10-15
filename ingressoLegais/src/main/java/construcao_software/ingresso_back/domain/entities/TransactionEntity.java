package construcao_software.ingresso_back.domain.entities;

import java.time.LocalDateTime;

import construcao_software.ingresso_back.infrastructure.persistence.hybernate.models.TenantModel;
import construcao_software.ingresso_back.infrastructure.persistence.hybernate.models.TicketModel;
import construcao_software.ingresso_back.infrastructure.persistence.hybernate.models.UserModel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class TransactionEntity {
    private Long transactionId;
    private TenantModel tenant;
    private UserModel buyer;
    private TicketModel ticket;
    private Double sellingPrice;
    private LocalDateTime transactionDate;
    private String transactionStatus;
}
