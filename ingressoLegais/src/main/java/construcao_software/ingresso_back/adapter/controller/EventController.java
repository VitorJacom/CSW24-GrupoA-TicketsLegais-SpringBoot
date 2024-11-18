package construcao_software.ingresso_back.adapter.controller;

import construcao_software.ingresso_back.application.dtos.EventDTO;
import construcao_software.ingresso_back.application.services.EventService;
import construcao_software.ingresso_back.domain.entities.EventEntity;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import lombok.RequiredArgsConstructor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;
import java.util.Optional;

@RestController
@RequestMapping("/api/events")
@RequiredArgsConstructor
public class EventController {

    @Autowired
    private EventService eventService;

    @GetMapping("/")
    public ResponseEntity<Collection<EventDTO>> getAllEvents() {
        return ResponseEntity.ok(eventService.getAllEvents());
    }
    
    // Read (Event by name filter)
    @GetMapping("/name/{name}")
    public ResponseEntity<Collection<EventDTO>> getEventsByName(@PathVariable String name) {
        return ResponseEntity.ok(eventService.getEventsByNameFilter(name));
    }

    // Read (Event by ID)
    @GetMapping("/{id}")
    public ResponseEntity<Optional<EventDTO>> getEventById(@PathVariable Long id) {
        Optional<EventDTO> event = eventService.getEventByID(id);

        if(event.isPresent()){
            return ResponseEntity.ok(event);
        }

        return ResponseEntity.notFound().build();
    }

        // Create (POST) - Cria um novo evento
    @PostMapping("/")
    public ResponseEntity<EventDTO> createEvent(@RequestBody EventDTO eventDTO) {
        EventDTO createdEvent = eventService.createEvent(eventDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdEvent);
    }

    // Update (PUT) - Atualiza um evento existente
    @PutMapping("/{id}")
    public ResponseEntity<EventDTO> updateEvent(@PathVariable Long id, @RequestBody EventDTO eventDTO) {
        return eventService.updateEvent(id, eventDTO)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // Delete (DELETE) - Deleta um evento existente
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteEvent(@PathVariable Long id) {
        if (eventService.deleteEvent(id)) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
    
}
