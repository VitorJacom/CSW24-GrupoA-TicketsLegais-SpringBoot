package construcao_software.ingresso_back.application.services;

import construcao_software.ingresso_back.application.mappers.EventMapper;
import construcao_software.ingresso_back.domain.entities.EventEntity;
import construcao_software.ingresso_back.infrastructure.persistence.repository.EventJpaRepository;
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
    public List<EventEntity> getAllEvents() {
        return repository.findAll().stream()
                .map(mapper::toEntity)
                .collect(Collectors.toList());
    }

    public Optional<EventEntity> getEventByID(Long eventId) {
        return repository.findById(eventId).map(mapper::toEntity);
    }
}
