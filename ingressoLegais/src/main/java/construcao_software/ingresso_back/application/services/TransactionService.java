package construcao_software.ingresso_back.application.services;

import construcao_software.ingresso_back.application.dtos.TicketDTO;
import construcao_software.ingresso_back.application.dtos.TransactionDTO;
import construcao_software.ingresso_back.application.dtos.UserDTO;
import construcao_software.ingresso_back.application.mappers.TicketMapper;
import construcao_software.ingresso_back.application.mappers.TransactionMapper;
import construcao_software.ingresso_back.application.mappers.UserMapper;
import construcao_software.ingresso_back.domain.entities.TicketEntity;
import construcao_software.ingresso_back.domain.entities.TransactionEntity;
import construcao_software.ingresso_back.domain.entities.UserEntity;
import construcao_software.ingresso_back.domain.enums.TransactionStatus;
import construcao_software.ingresso_back.adapter.persistence.hybernate.models.TransactionModel;
import construcao_software.ingresso_back.adapter.persistence.repository.TransactionJpaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class TransactionService {

    private final TransactionJpaRepository repository;

    private final TransactionMapper mapper;

    private final UserMapper userMapper;

    private final TicketMapper ticketMapper;

    private final EmailService emailService;

    public List<TransactionEntity> getAllTransactions() {
        return repository.findAll().stream()
                .map(mapper::toEntity)
                .collect(Collectors.toList());
    }

    public TransactionDTO createTransaction(TicketDTO ticketDTO, UserDTO buyerDTO) {
        TicketEntity ticketEntity = ticketMapper.toEntity(ticketDTO);
        UserEntity buyerEntity = userMapper.toEntity(buyerDTO);

        // Mock de pagamento
        boolean paymentSuccess = mockPaymentProcess();
        if (!paymentSuccess) {
            throw new RuntimeException("Falha no processamento do pagamento");
        }

        // Criar transação
        TransactionEntity transaction = new TransactionEntity(
                ticketEntity, buyerEntity, buyerEntity.getTenant(),
                ticketEntity.getOriginalPrice(), TransactionStatus.COMPLETED);

        TransactionModel transactionModel = repository.save(mapper.toModel(transaction));

        // Mock: Enviar e-mail se permitido
        if (buyerEntity.getNotificationPreferences() != null && buyerEntity.getNotificationPreferences().isAllowEmailNotifications()) {
            emailService.sendPurchaseConfirmation(buyerEntity.getEmail(), transactionModel);
        }

        return mapper.toDTO(transactionModel);
    }

    private boolean mockPaymentProcess() {
        return true;
    }

    // Buscar todas as transações de um vendedor (Tenant)
    public List<TransactionDTO> getAllTransactionsByTenant(Long tenantId) {
        List<TransactionModel> transactions = repository.findByTenant_TenantId(tenantId);
        return transactions.stream()
                .map(mapper::toDTO)
                .collect(Collectors.toList());
    }

    public List<TransactionEntity> getTransactionsByUser(Long userId) {
        return repository.findByBuyer_UserId(userId).stream()
                .map(mapper::toEntity)
                .collect(Collectors.toList());
    }

    public List<TransactionEntity> getAllTransactionsByUser(Long userId) {
    return repository.findAllByBuyer_UserId(userId).stream()
            .map(mapper::toEntity)
            .collect(Collectors.toList());
}

}
