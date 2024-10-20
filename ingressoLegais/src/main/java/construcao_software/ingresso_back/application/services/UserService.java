package construcao_software.ingresso_back.application.services;

import construcao_software.ingresso_back.application.dtos.TicketDTO;
import construcao_software.ingresso_back.application.mappers.UserMapper;
import construcao_software.ingresso_back.domain.base.TicketStatus;
import construcao_software.ingresso_back.domain.entities.UserEntity;
import construcao_software.ingresso_back.infrastructure.persistence.repository.UserJpaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class UserService {
    
    private final UserJpaRepository repository;
    private final UserMapper mapper;

    private final TicketService ticketService;

    public List<UserEntity> getAll() {
        return repository.findAll().stream()
                .map(mapper::toEntity)
                .collect(Collectors.toList());
    }

    public Optional<UserEntity> getUserByID(Long userID) {
        return repository.findById(userID).map(mapper::toEntity);
    }

    public Double getBalance(Long sellerId) {
        return ticketService.getAllBySellerId(sellerId, TicketStatus.SOLD).stream()
                .mapToDouble(TicketDTO::getOriginalPrice)
                .sum();
    }
}
