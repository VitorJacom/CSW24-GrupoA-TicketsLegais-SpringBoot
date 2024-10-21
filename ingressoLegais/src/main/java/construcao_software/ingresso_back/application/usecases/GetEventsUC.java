package construcao_software.ingresso_back.application.usecases;

import construcao_software.ingresso_back.application.dtos.EventDTO;
import construcao_software.ingresso_back.application.mappers.EventMapper;
import construcao_software.ingresso_back.application.services.EventService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Collection;

@Component
@RequiredArgsConstructor
public class GetEventsUC {

    private final EventService eventService;
    private final EventMapper eventMapper;

    public Collection<EventDTO> run() {
        return eventService.getAllEvents().stream()
                .map(eventMapper::toDTO)
                .toList();
    }

}
