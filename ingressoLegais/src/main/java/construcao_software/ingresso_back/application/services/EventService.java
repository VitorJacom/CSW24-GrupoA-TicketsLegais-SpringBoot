package construcao_software.ingresso_back.application.services;

import construcao_software.ingresso_back.application.dtos.EventDTO;
import construcao_software.ingresso_back.application.mappers.EventMapper;
import construcao_software.ingresso_back.adapter.persistence.hybernate.models.EventModel;
import construcao_software.ingresso_back.adapter.persistence.repository.EventJpaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class EventService {

    private final EventJpaRepository repository;
    private final EventMapper mapper;

    @Autowired
    public EventService(EventJpaRepository repository, EventMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    // Read (All)
    public List<EventDTO> getAllEvents() {
        return repository.findAll().stream()
                .map(mapper::toDTO)
                .collect(Collectors.toList());
    }

    // Read (By ID)
    public Optional<EventDTO> getEventByID(Long eventId) {
        return repository.findById(eventId).map(mapper::toDTO);
    }

    // Read (By Name Filter)
    public List<EventDTO> getEventsByNameFilter(String name) {
        return repository.getAllByFilterName(name).stream()
                .map(mapper::toDTO)
                .collect(Collectors.toList());
    }

        // Create (POST) - Cria um novo evento
        public EventDTO createEvent(EventDTO eventDTO) {
            EventModel eventEntity = mapper.toModel(eventDTO);
            EventModel savedEvent = repository.save(eventEntity);
            return mapper.toDTO(savedEvent);
        }
    
        // Update (PUT) - Atualiza um evento existente
        public Optional<EventDTO> updateEvent(Long eventId, EventDTO eventDTO) {
            return repository.findById(eventId)
                    .map(existingEvent -> {
                        EventModel updatedEvent = mapper.toModel(eventDTO);
                        updatedEvent.setEventId(existingEvent.getEventId()); // Garantir que o ID não seja alterado
                        EventModel savedEvent = repository.save(updatedEvent);
                        return mapper.toDTO(savedEvent);
                    });
        }
    
        // Delete (DELETE) - Deleta um evento existente pelo ID
        public boolean deleteEvent(Long eventId) {
            return repository.findById(eventId)
                    .map(event -> {
                        repository.delete(event);
                        return true;
                    }).orElse(false);
        }

}
