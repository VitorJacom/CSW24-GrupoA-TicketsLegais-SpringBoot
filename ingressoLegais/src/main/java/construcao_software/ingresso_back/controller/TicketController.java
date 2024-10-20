package construcao_software.ingresso_back.controller;

import construcao_software.ingresso_back.application.dtos.BuyTicketsDTO;
import construcao_software.ingresso_back.application.dtos.CreateTicketDTO;
import construcao_software.ingresso_back.application.dtos.TicketDTO;
import construcao_software.ingresso_back.application.dtos.TransactionDTO;
import construcao_software.ingresso_back.application.mappers.TicketMapper;
import construcao_software.ingresso_back.application.services.TicketService;
import construcao_software.ingresso_back.application.usecases.BuyTicketUC;
import construcao_software.ingresso_back.application.usecases.SellTicketUC;
import lombok.RequiredArgsConstructor;
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
    private final TicketMapper mapper;
    private final SellTicketUC sellTicketUC;
    private final BuyTicketUC buyTicketsUC;


    @GetMapping("/{eventId}")
    public ResponseEntity<List<TicketDTO>> getAllByEventId(@PathVariable("eventId") Long eventId) {
        List<TicketDTO> tickets = service.getAllByEventId(eventId).stream()
                .map(mapper::toDTO)
                .collect(Collectors.toList());
        return ResponseEntity.ok(tickets);
    }

    @PostMapping("/vender")
    public ResponseEntity<TicketDTO> venderIngresso(@RequestBody CreateTicketDTO createTicketDTO) {
        return ResponseEntity.ok(sellTicketUC.run(createTicketDTO));
    }

    @PostMapping("/comprar")
    public ResponseEntity<Collection<TransactionDTO>> comprarIngresso(@RequestBody BuyTicketsDTO buyTicketsDTO) {
        return ResponseEntity.ok(buyTicketsUC.run(buyTicketsDTO));
    }

}
