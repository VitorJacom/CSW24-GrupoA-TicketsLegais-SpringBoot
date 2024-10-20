package construcao_software.ingresso_back.controller;

import construcao_software.ingresso_back.application.dtos.EventDTO;
import construcao_software.ingresso_back.application.usecases.GetEventsUC;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;

@RestController
@RequestMapping("/api/events")
@RequiredArgsConstructor
public class EventController {

    private final GetEventsUC getEventsUC;

    @GetMapping("/")
    public ResponseEntity<Collection<EventDTO>> getAllEvents() {
        return ResponseEntity.ok(getEventsUC.run());
    }    
}
