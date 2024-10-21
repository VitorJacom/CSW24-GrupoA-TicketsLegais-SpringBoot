package construcao_software.ingresso_back.application.services;

import construcao_software.ingresso_back.application.dtos.TicketDTO;
import construcao_software.ingresso_back.application.mappers.TicketMapper;
import construcao_software.ingresso_back.domain.base.TicketStatus;
import construcao_software.ingresso_back.domain.entities.TicketEntity;
import construcao_software.ingresso_back.domain.entities.UserEntity;
import construcao_software.ingresso_back.infrastructure.persistence.repository.TicketJpaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class TicketService {

    private final TicketJpaRepository repository;
    private final TicketMapper mapper;

    @Autowired
    public TicketService(TicketJpaRepository repository, TicketMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    public List<TicketEntity> getAllByEventId(Long eventId) {
        return repository.getAllByEvent_EventId(eventId).stream()
                .map(mapper::toEntity)
                .collect(Collectors.toList());
    }

    public TicketEntity createTicket(TicketEntity ticket) {
        return mapper.toEntity(repository.save(mapper.toModel(ticket)));
    }

    public Collection<TicketDTO> getAllBySellerId(Long sellerId, TicketStatus status) {
        if (status == null) {
            return repository.getAllBySeller_UserId(sellerId).stream()
                    .map(mapper::toEntity).map(mapper::toDTO)
                    .collect(Collectors.toList());
        }
        return repository.getAllBySeller_UserIdAndStatus(sellerId, status).stream()
                .map(mapper::toEntity).map(mapper::toDTO)
                .collect(Collectors.toList());
    }

    public Optional<TicketEntity> getTicketById(Long ticketId) {
        return repository.findById(ticketId).map(mapper::toEntity);
    }

    public void processTicketSale(TicketEntity ticket, UserEntity user) {
        ticket.setStatus(TicketStatus.SOLD);
        ticket.setTenant(user.getTenant());

        repository.save(mapper.toModel(ticket));
    }
}
