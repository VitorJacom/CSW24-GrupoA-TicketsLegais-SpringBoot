package construcao_software.ingresso_back.application.services;

import construcao_software.ingresso_back.application.dtos.TicketDTO;
import construcao_software.ingresso_back.application.dtos.UserDTO;
import construcao_software.ingresso_back.application.mappers.UserMapper;
import construcao_software.ingresso_back.domain.enums.TicketStatus;
import construcao_software.ingresso_back.infrastructure.persistence.hybernate.models.TicketModel;
import construcao_software.ingresso_back.infrastructure.persistence.repository.TicketJpaRepository;
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
    private final UserMapper userMapper;
    private final TicketJpaRepository ticketRepository;

    public List<UserDTO> getAll() {
        return repository.findAll().stream()
                .map(userMapper::toDTO)
                .collect(Collectors.toList());
    }

    public Optional<UserDTO> getUserByID(Long userID) {
        return repository.findById(userID).map(userMapper::toDTO);
    }

    public Double getBalance(Long sellerId) {
        List<TicketModel> tickets = ticketRepository.findBySellerIdAndStatus(sellerId, TicketStatus.SOLD);
        
        return tickets.stream()
                .mapToDouble(TicketModel::getOriginalPrice) // ou usar um método para converter para TicketDTO se necessário
                .sum();
    }
}
