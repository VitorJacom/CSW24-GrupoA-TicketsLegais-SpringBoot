package construcao_software.ingresso_back.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import construcao_software.ingresso_back.service.dtos.TicketDTO;
import construcao_software.ingresso_back.service.mappers.TicketMapper;
import construcao_software.ingresso_back.service.services.TicketService;

public class TicketController {
    
    private final TicketService service;
    private final TicketMapper mapper;

    @Autowired
    public TicketController(TicketService service, TicketMapper mapper) {
        this.service = service;
        this.mapper = mapper;
    }

    // Read By ID
    @GetMapping("/{eventId}")
    public ResponseEntity<List<TicketDTO>> getAllByEventId(@PathVariable("eventId") Long eventId) {
        List<TicketDTO> tickets = service.getAllByEventId(eventId).stream()
                .map(mapper::toDTO)
                .collect(Collectors.toList());
        return ResponseEntity.ok(tickets);
    }
}
