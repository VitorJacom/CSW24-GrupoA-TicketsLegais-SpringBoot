package construcao_software.ingresso_back.controller;

import construcao_software.ingresso_back.adapter.controller.TransactionController;
import construcao_software.ingresso_back.application.dtos.*;
import construcao_software.ingresso_back.application.services.TransactionService;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.ResponseEntity;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

class TransactionControllerTest {

    @Mock
    private TransactionService service;

    @InjectMocks
    private TransactionController controller;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void shouldCreateTransaction() {
        TransactionRequest request = new TransactionRequest();
        request.setTicketDTO(new TicketDTO());
        request.setBuyerDTO(new UserDTO());
        TransactionDTO transactionDTO = new TransactionDTO();

        when(service.createTransaction(any(TicketDTO.class), any(UserDTO.class))).thenReturn(transactionDTO);

        ResponseEntity<TransactionDTO> response = controller.createTransaction(request);

        assertNotNull(response);
        assertEquals(201, response.getStatusCode().value());
        verify(service).createTransaction(request.getTicketDTO(), request.getBuyerDTO());
    }

    @Test
    void shouldGetAllTransactionsByTenant() {
        Long tenantId = 1L;
        List<TransactionDTO> transactions = List.of(new TransactionDTO());

        when(service.getAllTransactionsByTenant(tenantId)).thenReturn(transactions);

        ResponseEntity<List<TransactionDTO>> response = controller.getAllTransactionsByTenant(tenantId);

        assertNotNull(response);
        assertEquals(200, response.getStatusCode().value());
        assertEquals(1, response.getBody().size());
        verify(service).getAllTransactionsByTenant(tenantId);
    }
}
