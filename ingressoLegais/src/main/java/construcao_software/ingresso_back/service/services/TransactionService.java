package construcao_software.ingresso_back.service.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import construcao_software.ingresso_back.domain.entities.TransactionEntity;
import construcao_software.ingresso_back.infrastructure.persistence.repository.TransactionJpaRepository;
import construcao_software.ingresso_back.service.mappers.TransactionMapper;

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
}
