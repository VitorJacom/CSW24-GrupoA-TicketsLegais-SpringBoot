package construcao_software.ingresso_back.application.dtos;

import java.time.LocalDateTime;

import construcao_software.ingresso_back.infrastructure.persistence.hybernate.models.TenantModel;
import construcao_software.ingresso_back.infrastructure.persistence.hybernate.models.TicketModel;
import construcao_software.ingresso_back.infrastructure.persistence.hybernate.models.UserModel;
import lombok.Data;

@Data
public class TransactionDTO {
    
    private Long transactionId;
    private TenantModel tenant;
    private UserModel buyer;
    private TicketModel ticket;
    private Double sellingPrice;
    private LocalDateTime transactionDate;
    private String transactionStatus;    
}
