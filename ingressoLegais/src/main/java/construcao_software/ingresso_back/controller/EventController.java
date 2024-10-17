package construcao_software.ingresso_back.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import construcao_software.ingresso_back.service.dtos.EventDTO;
import construcao_software.ingresso_back.service.mappers.EventMapper;
import construcao_software.ingresso_back.service.services.EventService;

@RestController
public class EventController {

    private final EventService service;
    private final EventMapper mapper;

    @Autowired
    public EventController(EventService service, EventMapper mapper) {
        this.service = service;
        this.mapper = mapper;
    }

    public ResponseEntity<List<EventDTO>> getAllEvents() {
        List<EventDTO> events = service.getAllEvents().stream()
                .map(mapper::toDTO)
                .collect(Collectors.toList());
        return ResponseEntity.ok(events);
    }    
}
