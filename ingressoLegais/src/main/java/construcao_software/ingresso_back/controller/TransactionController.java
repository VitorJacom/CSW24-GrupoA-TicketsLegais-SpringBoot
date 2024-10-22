package construcao_software.ingresso_back.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import construcao_software.ingresso_back.application.dtos.TransactionDTO;
import construcao_software.ingresso_back.domain.entities.TransactionEntity;
import construcao_software.ingresso_back.application.dtos.TransactionRequest;
import construcao_software.ingresso_back.application.mappers.TransactionMapper;
import construcao_software.ingresso_back.application.services.TransactionService;
import io.swagger.v3.oas.annotations.parameters.RequestBody;

@RestController
@RequestMapping("/api/transactions")
public class TransactionController {

    private final TransactionService service;
    private final TransactionMapper mapper;

    @Autowired
    public TransactionController(TransactionService service, TransactionMapper mapper) {
        this.service = service;
        this.mapper = mapper;
    }

    @GetMapping("/")
    public ResponseEntity<List<TransactionDTO>> getAllTransactions() {
        List<TransactionDTO> transactions = service.getAllTransactions().stream()
                .map(mapper::toDTO)
                .collect(Collectors.toList());
        return ResponseEntity.ok(transactions);
    }

    @PostMapping("/create")
    public ResponseEntity<TransactionDTO> createTransaction(@RequestBody TransactionRequest request) {
        TransactionDTO transaction = service.createTransaction(request.getTicketDTO(), request.getBuyerDTO());
        return ResponseEntity.status(HttpStatus.CREATED).body(transaction);
    }

    @GetMapping("/tenant/{tenantId}")
    public ResponseEntity<List<TransactionDTO>> getAllTransactionsByTenant(@PathVariable Long tenantId) {
        List<TransactionDTO> transactions = service.getAllTransactionsByTenant(tenantId);
        return ResponseEntity.ok(transactions);
    }

    @GetMapping("/user/{userId}")
    public List<TransactionEntity> getTransactionsByUser(@PathVariable Long userId) {
        return service.getTransactionsByUser(userId);
    }

    @GetMapping("/user/{userId}/all")
    public List<TransactionEntity> getAllTransactionsByUser(@PathVariable Long userId) {
        return service.getAllTransactionsByUser(userId);
    }
}
