package construcao_software.ingresso_back.controller;

import construcao_software.ingresso_back.application.dtos.BuyTicketsDTO;
import construcao_software.ingresso_back.application.dtos.CreateTicketDTO;
import construcao_software.ingresso_back.application.dtos.TicketDTO;
import construcao_software.ingresso_back.application.dtos.TransactionDTO;
import construcao_software.ingresso_back.application.mappers.TicketMapper;
import construcao_software.ingresso_back.application.services.TicketService;
import construcao_software.ingresso_back.domain.enums.TicketStatus;
import lombok.RequiredArgsConstructor;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/tickets")
@RequiredArgsConstructor
public class TicketController {
    
    private final TicketService service;

    // Obter todos os tickets por ID de evento
    @GetMapping("/event/{eventId}")
    public ResponseEntity<List<TicketDTO>> getAllByEventId(@PathVariable("eventId") Long eventId) {
        List<TicketDTO> tickets = service.getAllByEventId(eventId);
        return ResponseEntity.ok(tickets);
    }

    // cria um ticket para Vender
    @PostMapping("/sell")
    public ResponseEntity<TicketDTO> sellTicket(@RequestBody CreateTicketDTO createTicketDTO) {
        TicketDTO soldTicket = service.sellTicket(createTicketDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(soldTicket);
    }

    // Comprar um ticket (Processar a compra)
    @PostMapping("/buy")
    public ResponseEntity<Collection<TicketDTO>> buyTickets(@RequestBody BuyTicketsDTO buyTicketsDTO) {

        Collection<TicketDTO> ticketDTOs = service.processTicketSale(buyTicketsDTO);
        return ResponseEntity.ok(ticketDTOs);
    }

    // Obter um ticket por ID
    @GetMapping("/{ticketId}")
    public ResponseEntity<TicketDTO> getTicketById(@PathVariable("ticketId") Long ticketId) {
        return service.getTicketById(ticketId)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/user/{userId}")
    public List<TicketDTO> getTicketsByUser(@PathVariable Long userId) {
        return service.getTicketsByUser(userId);
    }
    
    // Obter todos os tickets por ID de vendedor e status
    @GetMapping("/seller/{sellerId}")
    public ResponseEntity<Collection<TicketDTO>> getAllBySellerId(
            @PathVariable("sellerId") Long sellerId,
            @RequestParam(value = "status", required = false) TicketStatus status) {
        Collection<TicketDTO> tickets = service.getAllBySellerId(sellerId, status);
        return ResponseEntity.ok(tickets);
    }


    // Validar e usar o ingresso
    @PutMapping("/validate/{ticketId}")
    public ResponseEntity<TicketDTO> validateAndUseTicket(@PathVariable("ticketId") Long ticketId) {
        try {
            TicketDTO ticketDTO = service.validateAndUseTicket(ticketId).get();
            return ResponseEntity.ok(ticketDTO);
        } catch (RuntimeException ex) {
            return ResponseEntity.badRequest().body(null);
        }
    }

}
