package construcao_software.ingresso_back.service.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import construcao_software.ingresso_back.domain.entities.EventEntity;
import construcao_software.ingresso_back.infrastructure.persistence.repository.EventJpaRepository;
import construcao_software.ingresso_back.service.mappers.EventMapper;

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
}
