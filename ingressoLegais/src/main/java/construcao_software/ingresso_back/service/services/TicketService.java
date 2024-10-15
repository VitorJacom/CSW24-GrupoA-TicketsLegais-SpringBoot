package construcao_software.ingresso_back.service.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import construcao_software.ingresso_back.domain.entities.TicketEntity;
import construcao_software.ingresso_back.infrastructure.persistence.repository.TicketJpaRepository;
import construcao_software.ingresso_back.service.mappers.TicketMapper;

@Service
public class TicketService {
    
    private final TicketJpaRepository repository;
    private final TicketMapper mapper;

    @Autowired
    public TicketService(TicketJpaRepository repository, TicketMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    // Get all tickets by event ID
    public List<TicketEntity> getAllByEventId(Long eventId) {
        return repository.getAllByEventId(eventId).stream()
                .map(mapper::toEntity)
                .collect(Collectors.toList());
    }
}
