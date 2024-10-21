package construcao_software.ingresso_back.application.usecases;

import construcao_software.ingresso_back.application.dtos.TicketDTO;
import construcao_software.ingresso_back.application.services.TicketService;
import construcao_software.ingresso_back.domain.enums.TicketStatus;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Collection;

@Component
@RequiredArgsConstructor
public class GetUserSoldTickets {

    private final TicketService ticketService;

    // public Collection<TicketDTO> run(Long sellerId, TicketStatus status) {
    //     return ticketService.getAllBySellerId(sellerId, status);
    // }
}
