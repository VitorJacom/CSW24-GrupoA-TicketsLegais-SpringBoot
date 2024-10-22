package construcao_software.ingresso_back.application.dtos;

import lombok.Data;

@Data
public class TransactionRequest {
    
    private TicketDTO ticketDTO;
    private UserDTO buyerDTO;
}