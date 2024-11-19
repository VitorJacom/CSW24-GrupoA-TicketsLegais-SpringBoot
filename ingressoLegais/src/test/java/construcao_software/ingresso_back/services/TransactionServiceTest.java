package construcao_software.ingresso_back.services;

import construcao_software.ingresso_back.adapter.persistence.hybernate.models.TransactionModel;
import construcao_software.ingresso_back.adapter.persistence.repository.TransactionJpaRepository;
import construcao_software.ingresso_back.application.dtos.*;
import construcao_software.ingresso_back.application.mappers.TransactionMapper;
import construcao_software.ingresso_back.application.mappers.TicketMapper;
import construcao_software.ingresso_back.application.mappers.UserMapper;
import construcao_software.ingresso_back.application.services.EmailService;
import construcao_software.ingresso_back.application.services.TransactionService;
import construcao_software.ingresso_back.domain.entities.TicketEntity;
import construcao_software.ingresso_back.domain.entities.TransactionEntity;
import construcao_software.ingresso_back.domain.entities.UserEntity;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.*;

class TransactionServiceTest {

    @Mock
    private TransactionJpaRepository repository;

    @Mock
    private TransactionMapper transactionMapper;

    @Mock
    private TicketMapper ticketMapper;

    @Mock
    private UserMapper userMapper;

    @Mock
    private EmailService emailService;

    @InjectMocks
    private TransactionService service;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void shouldGetAllTransactions() {
        List<TransactionModel> transactionModels = List.of(new TransactionModel());
        List<TransactionEntity> transactionEntities = List.of(new TransactionEntity());

        when(repository.findAll()).thenReturn(transactionModels);
        when(transactionMapper.toEntity(any(TransactionModel.class))).thenReturn(transactionEntities.get(0));

        List<TransactionEntity> result = service.getAllTransactions();

        assertEquals(1, result.size());
        verify(repository).findAll();
    }

    @Test
    void shouldCreateTransaction() {
        TicketDTO ticketDTO = new TicketDTO();
        UserDTO buyerDTO = new UserDTO();
        TransactionModel transactionModel = new TransactionModel();
        TransactionDTO transactionDTO = new TransactionDTO();

        when(ticketMapper.toEntity(ticketDTO)).thenReturn(new TicketEntity()); 
        when(userMapper.toEntity(buyerDTO)).thenReturn(new UserEntity()); 

        when(transactionMapper.toModel(any(TransactionEntity.class))).thenReturn(transactionModel);
        when(repository.save(transactionModel)).thenReturn(transactionModel);
        when(transactionMapper.toDTO(transactionModel)).thenReturn(transactionDTO);

        TransactionDTO result = service.createTransaction(ticketDTO, buyerDTO);

        assertNotNull(result);
        verify(repository).save(transactionModel);
        verify(emailService, times(0)).sendPurchaseConfirmation(anyString(), any(TransactionModel.class));
    }

    @Test
    void shouldGetAllTransactionsByTenant() {
        Long tenantId = 1L;
        List<TransactionModel> transactionModels = List.of(new TransactionModel());
        List<TransactionDTO> transactionDTOs = List.of(new TransactionDTO());

        when(repository.findByTenant_TenantId(tenantId)).thenReturn(transactionModels);
        when(transactionMapper.toDTO(any(TransactionModel.class))).thenReturn(transactionDTOs.get(0));

        List<TransactionDTO> result = service.getAllTransactionsByTenant(tenantId);

        assertEquals(1, result.size());
        verify(repository).findByTenant_TenantId(tenantId);
    }
}
