package construcao_software.ingresso_back.application.usecases;

import construcao_software.ingresso_back.application.dtos.BuyTicketsDTO;
import construcao_software.ingresso_back.application.dtos.TransactionDTO;
import construcao_software.ingresso_back.application.mappers.TransactionMapper;
import construcao_software.ingresso_back.application.services.TicketService;
import construcao_software.ingresso_back.application.services.TransactionService;
import construcao_software.ingresso_back.application.services.UserService;
import construcao_software.ingresso_back.domain.entities.TicketEntity;
import construcao_software.ingresso_back.domain.entities.TransactionEntity;
import construcao_software.ingresso_back.domain.entities.UserEntity;
import construcao_software.ingresso_back.domain.enums.TicketStatus;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Collection;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class BuyTicketUC {

    private final TransactionService transactionService;
    private final TicketService ticketService;
    private final UserService userService;

    private final TransactionMapper transactionMapper;

    public Collection<TransactionDTO> run(BuyTicketsDTO buyTicketsDTO) {

        UserEntity user = userService.getUserByID(buyTicketsDTO.userId()).orElseThrow(() -> new RuntimeException("User not found"));

        ArrayList<TransactionEntity> transactions = new ArrayList<>();

        for (Long ticketID : buyTicketsDTO.ticketIds()) {
            TicketEntity ticket = ticketService.getTicketById(ticketID).orElseThrow(() -> new RuntimeException("Ticket not found"));

            if (!ticket.getStatus().equals(TicketStatus.AVAILABLE))
                throw new RuntimeException("Ticket not available: " + ticketID);

            TransactionEntity transaction = transactionService.createTransaction(ticket, user);
            transactions.add(transaction);

            ticketService.processTicketSale(ticket, user);
        }

        return transactions.stream()
                .map(transactionMapper::toDTO)
                .collect(Collectors.toList());
    }
}

