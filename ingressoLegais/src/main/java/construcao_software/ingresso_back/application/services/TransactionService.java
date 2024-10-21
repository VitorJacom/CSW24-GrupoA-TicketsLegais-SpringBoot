package construcao_software.ingresso_back.application.services;

import construcao_software.ingresso_back.application.mappers.TransactionMapper;
import construcao_software.ingresso_back.domain.base.TransactionStatus;
import construcao_software.ingresso_back.domain.entities.TicketEntity;
import construcao_software.ingresso_back.domain.entities.TransactionEntity;
import construcao_software.ingresso_back.domain.entities.UserEntity;
import construcao_software.ingresso_back.infrastructure.persistence.repository.TransactionJpaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class TransactionService {
        
        private final TransactionJpaRepository repository;
        private final TransactionMapper mapper;
    
        @Autowired
        public TransactionService(TransactionJpaRepository repository, TransactionMapper mapper) {
            this.repository = repository;
            this.mapper = mapper;
        }
    
        
        public List<TransactionEntity> getAllTransactions() {
            return repository.findAll().stream()
                    .map(mapper::toEntity)
                    .collect(Collectors.toList());
        }


    public TransactionEntity createTransaction(TicketEntity ticket, UserEntity buyer) {
        TransactionEntity transaction = new TransactionEntity();
        transaction.setTicket(ticket);
        transaction.setBuyer(buyer);
        transaction.setTenant(buyer.getTenant());
        transaction.setTransactionDate(LocalDateTime.now());
        transaction.setSellingPrice(ticket.getOriginalPrice());
        transaction.setTransactionStatus(TransactionStatus.COMPLETED);
        return mapper.toEntity(repository.save(mapper.toModel(transaction)));
    }
}
