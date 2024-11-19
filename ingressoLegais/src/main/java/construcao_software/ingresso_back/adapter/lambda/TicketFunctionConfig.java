package construcao_software.ingresso_back.adapter.lambda;

import construcao_software.ingresso_back.application.dtos.BuyTicketsDTO;
import construcao_software.ingresso_back.application.dtos.CreateTicketDTO;
import construcao_software.ingresso_back.application.dtos.TicketDTO;
import construcao_software.ingresso_back.application.services.TicketService;
import construcao_software.ingresso_back.domain.enums.TicketStatus;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.function.BiFunction;
import java.util.function.Function;

@Configuration
public class TicketFunctionConfig {

    private final TicketService service;

    public TicketFunctionConfig(TicketService service) {
        this.service = service;
    }

    // Supplier para obter todos os tickets por ID de evento
    @Bean
    public Function<Long, List<TicketDTO>> getAllByEventId() {
        return service::getAllByEventId;
    }

    // Function para criar um ticket para vender
    @Bean
    public Function<CreateTicketDTO, TicketDTO> sellTicket() {
        return service::sellTicket;
    }

    // Function para processar a compra de tickets
    @Bean
    public Function<BuyTicketsDTO, Collection<TicketDTO>> buyTickets() {
        return service::processTicketSale;
    }

    // Function para obter um ticket por ID
    @Bean
    public Function<Long, Optional<TicketDTO>> getTicketById() {
        return service::getTicketById;
    }

    // Function para obter tickets por Tenant ID
    @Bean
    public Function<Long, List<TicketDTO>> getTicketsByTenantId() {
        return service::getTicketsByTenantId;
    }

    // BiFunction para obter tickets por Seller ID e status
    @Bean
    public BiFunction<Long, TicketStatus, Collection<TicketDTO>> getAllBySellerId() {
        return service::getAllBySellerId;
    }

    // Function para validar e usar um ticket pelo código
    @Bean
    public Function<String, TicketDTO> validateAndUseTicket() {
        return service::validateAndUseTicket;
    }
}
