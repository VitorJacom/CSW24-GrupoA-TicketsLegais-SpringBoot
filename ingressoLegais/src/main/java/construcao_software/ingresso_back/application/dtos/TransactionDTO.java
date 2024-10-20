package construcao_software.ingresso_back.application.dtos;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class TransactionDTO {
    
    private Long transactionId;
    private TenantDTO tenant;
    private UserDTO buyer;
    private TicketDTO ticket;
    private Double sellingPrice;
    private LocalDateTime transactionDate;
    private String transactionStatus;    
}
