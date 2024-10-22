package construcao_software.ingresso_back.application.dtos;

import lombok.Data;

import java.time.LocalDateTime;

import org.springframework.transaction.TransactionStatus;

@Data
public class TransactionDTO {
    
    private Long transactionId;
    private TenantDTO tenant;
    private UserDTO buyer;
    private TicketDTO ticket;
    private Double sellingPrice;
    private LocalDateTime transactionDate;
    private TransactionStatus transactionStatus;    
}
