package construcao_software.ingresso_back.application.usecases;

import construcao_software.ingresso_back.application.dtos.CreateTicketDTO;
import construcao_software.ingresso_back.application.dtos.TicketDTO;
import construcao_software.ingresso_back.application.mappers.TicketMapper;
import construcao_software.ingresso_back.application.services.EventService;
import construcao_software.ingresso_back.application.services.TicketService;
import construcao_software.ingresso_back.application.services.UserService;
import construcao_software.ingresso_back.domain.entities.EventEntity;
import construcao_software.ingresso_back.domain.entities.TicketEntity;
import construcao_software.ingresso_back.domain.entities.UserEntity;
import construcao_software.ingresso_back.domain.enums.TicketStatus;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
@RequiredArgsConstructor
public class SellTicketUC {

    private final UserService userService;
    private final EventService eventService;
    private final TicketService ticketService;
    private final TicketMapper ticketMapper;

    public TicketDTO run(CreateTicketDTO createTicketDTO) {

        UserEntity seller = userService.getUserByID(createTicketDTO.sellerId())
                .orElseThrow(() -> new RuntimeException("Seller not found"));

        EventEntity event = eventService.getEventByID(createTicketDTO.eventId())
                .orElseThrow(() -> new RuntimeException("Event not found"));

        TicketEntity ticket = new TicketEntity();
        ticket.setSeller(seller);
        ticket.setEvent(event);
        ticket.setOriginalPrice(createTicketDTO.originalPrice());
        ticket.setStatus(TicketStatus.AVAILABLE);
        ticket.setUniqueVerificationCode(UUID.randomUUID().toString());

        return ticketMapper.toDTO(ticketService.createTicket(ticket));

    }
}
