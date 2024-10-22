package construcao_software.ingresso_back.application.services;

import construcao_software.ingresso_back.application.dtos.TicketDTO;
import construcao_software.ingresso_back.application.dtos.TransactionDTO;
import construcao_software.ingresso_back.application.dtos.UserDTO;
import construcao_software.ingresso_back.application.mappers.TicketMapper;
import construcao_software.ingresso_back.application.mappers.TransactionMapper;
import construcao_software.ingresso_back.application.mappers.UserMapper;
import construcao_software.ingresso_back.domain.entities.PrivacySettingsEntity;
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
    @Autowired
    private EmailService emailService;
    @Autowired
    private PrivacySettingsService privacySettingsService;

    public List<TransactionEntity> getAllTransactions() {
        return repository.findAll().stream()
                .map(mapper::toEntity)
                .collect(Collectors.toList());
    }

    public TransactionDTO createTransaction(TicketDTO ticketDTO, UserDTO buyerDTO) {
        TicketEntity ticketEntity = ticketMapper.toEntity(ticketDTO);
        UserEntity buyerEntity = userMapper.toEntity(buyerDTO);

        // Verificar configurações de privacidade
        PrivacySettingsEntity privacySettings = privacySettingsService.getSettingsByUser(buyerEntity.getUserId());

        if (privacySettings != null && !privacySettings.isTransactionHistoryVisibility()) {
            throw new RuntimeException("Usuário não permite o compartilhamento de histórico de transações");
        }

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
        if (privacySettings != null && privacySettings.isAllowMarketingCommunications()) {
            emailService.sendPurchaseConfirmation(buyerDTO.getEmail(), transactionModel);
        }

        return mapper.toDTO(transactionModel);
    }

    // TODO: MOCK
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
        return repository.findByUserId(userId).stream()
                .map(mapper::toEntity)
                .collect(Collectors.toList());
    }

    public List<TransactionEntity> getAllTransactionsByUser(Long userId) {
    return repository.findAllByUserId(userId).stream()
            .map(mapper::toEntity)
            .collect(Collectors.toList());
}

}
