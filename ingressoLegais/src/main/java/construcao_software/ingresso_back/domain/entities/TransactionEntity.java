package construcao_software.ingresso_back.domain.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

import construcao_software.ingresso_back.domain.enums.TransactionStatus;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class TransactionEntity {

    private Long transactionId;
    private TenantEntity tenant;
    private UserEntity buyer;
    private TicketEntity ticket;
    private Double sellingPrice;
    private LocalDateTime transactionDate;
    private TransactionStatus transactionStatus;

            Double originalPrice, TransactionStatus completed) {

        this.ticket = ticketEntity;
        this.buyer = buyerEntity;
        this.tenant = tenantEntity;
        this.sellingPrice = originalPrice;
        this.transactionStatus = completed;
        transactionDate = LocalDateTime.now();
    }
}
