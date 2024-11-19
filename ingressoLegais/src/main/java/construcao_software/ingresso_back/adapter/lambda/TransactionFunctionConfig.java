package construcao_software.ingresso_back.adapter.lambda;

import construcao_software.ingresso_back.application.dtos.TransactionDTO;
import construcao_software.ingresso_back.application.dtos.TransactionRequest;
import construcao_software.ingresso_back.domain.entities.TransactionEntity;
import construcao_software.ingresso_back.application.mappers.TransactionMapper;
import construcao_software.ingresso_back.application.services.TransactionService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;
import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collectors;

@Configuration
public class TransactionFunctionConfig {

    private final TransactionService service;
    private final TransactionMapper mapper;

    public TransactionFunctionConfig(TransactionService service, TransactionMapper mapper) {
        this.service = service;
        this.mapper = mapper;
    }

    // Supplier para obter todas as transações
    @Bean
    public Supplier<List<TransactionDTO>> getAllTransactions() {
        return () -> service.getAllTransactions()
                .stream()
                .map(mapper::toDTO)
                .collect(Collectors.toList());
    }

    // Function para criar uma nova transação
    @Bean
    public BiFunction<TransactionRequest, Void, TransactionDTO> createTransaction() {
        return (request, unused) -> service.createTransaction(request.getTicketDTO(), request.getBuyerDTO());
    }

    // Function para obter transações por Tenant ID
    @Bean
    public Function<Long, List<TransactionDTO>> getAllTransactionsByTenant() {
        return service::getAllTransactionsByTenant;
    }

    // Function para obter transações por User ID (somente as principais)
    @Bean
    public Function<Long, List<TransactionEntity>> getTransactionsByUser() {
        return service::getTransactionsByUser;
    }

    // Function para obter todas as transações por User ID
    @Bean
    public Function<Long, List<TransactionEntity>> getAllTransactionsByUser() {
        return service::getAllTransactionsByUser;
    }
}
