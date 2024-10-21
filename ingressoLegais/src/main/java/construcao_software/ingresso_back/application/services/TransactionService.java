package construcao_software.ingresso_back.application.services;

import construcao_software.ingresso_back.application.dtos.TicketDTO;
import construcao_software.ingresso_back.application.dtos.TransactionDTO;
import construcao_software.ingresso_back.application.dtos.UserDTO;
import construcao_software.ingresso_back.application.mappers.TicketMapper;
import construcao_software.ingresso_back.application.mappers.TransactionMapper;
import construcao_software.ingresso_back.application.mappers.UserMapper;
import construcao_software.ingresso_back.domain.entities.TenantEntity;
import construcao_software.ingresso_back.domain.entities.TicketEntity;
import construcao_software.ingresso_back.domain.entities.TransactionEntity;
import construcao_software.ingresso_back.domain.entities.UserEntity;
import construcao_software.ingresso_back.domain.enums.TransactionStatus;
import construcao_software.ingresso_back.infrastructure.persistence.hybernate.models.TransactionModel;
import construcao_software.ingresso_back.infrastructure.persistence.repository.TransactionJpaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class TransactionService {
        
        @Autowired
        private TransactionJpaRepository repository;
        @Autowired
        private TransactionMapper mapper;
        @Autowired
        private UserMapper userMapper;
        @Autowired
        private TicketMapper ticketMapper;
    
        
        public List<TransactionEntity> getAllTransactions() {
            return repository.findAll().stream()
                    .map(mapper::toEntity)
                    .collect(Collectors.toList());
        }


    public TransactionDTO createTransaction(TicketDTO ticketDTO, UserDTO buyerDTO) {
        TicketEntity ticketEntity = ticketMapper.toEntity(ticketDTO);
        UserEntity buyerEntity = userMapper.toEntity(buyerDTO);

        //TODO: Mockar a transacao
        //TODO: fazer a verificacao se o tenent existe
        TenantEntity tenantEntity = buyerEntity.getTenant();

        TransactionEntity transaction = new TransactionEntity(ticketEntity, buyerEntity, tenantEntity,ticketEntity.getOriginalPrice(),TransactionStatus.COMPLETED);

        TransactionModel transactionModel = repository.save(mapper.toModel(transaction));

        return mapper.toDTO(transactionModel);
    }
}
