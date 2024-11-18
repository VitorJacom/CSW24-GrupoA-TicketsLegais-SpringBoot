package construcao_software.ingresso_back.adapter.lambda;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import construcao_software.ingresso_back.application.dtos.EventDTO;
import construcao_software.ingresso_back.application.dtos.UpdateEventRequestDTO;
import construcao_software.ingresso_back.application.services.EventService;

import java.util.Collection;
import java.util.Optional;
import java.util.function.Function;
import java.util.function.Supplier;

@Configuration
public class EventFunctionConfig {

    private final EventService eventService;

    public EventFunctionConfig(EventService eventService) {
        this.eventService = eventService;
    }

    // Supplier para obter todos os eventos
    @Bean
    public Supplier<Collection<EventDTO>> getAllEvents() {
        return eventService::getAllEvents;
    }

    // Function para obter eventos filtrados por nome
    @Bean
    public Function<String, Collection<EventDTO>> getEventsByName() {
        return eventService::getEventsByNameFilter;
    }

    // Function para obter evento por ID
    @Bean
    public Function<Long, Optional<EventDTO>> getEventById() {
        return eventService::getEventByID;
    }

    // Consumer para criar um novo evento
    @Bean
    public Function<EventDTO, EventDTO> createEvent() {
        return eventService::createEvent;
    }

    // Function para atualizar um evento existente
    @Bean
    public Function<UpdateEventRequestDTO, Optional<EventDTO>> updateEvent() {
        return request -> eventService.updateEvent(request.getId(), request.getEventDTO());
    }

    // Consumer para deletar um evento por ID
    @Bean
    public Function<Long, Boolean> deleteEvent() {
        return eventService::deleteEvent;
    }
}
