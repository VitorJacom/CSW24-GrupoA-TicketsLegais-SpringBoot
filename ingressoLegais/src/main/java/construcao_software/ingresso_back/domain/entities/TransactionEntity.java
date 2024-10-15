package construcao_software.ingresso_back.domain.entities;

import java.time.LocalDateTime;

import construcao_software.ingresso_back.infrastructure.persistence.hybernate.models.TenantModel;
import construcao_software.ingresso_back.infrastructure.persistence.hybernate.models.TicketModel;
import construcao_software.ingresso_back.infrastructure.persistence.hybernate.models.UserModel;

public class TransactionEntity {
        
    private Long transactionId;
    private TenantModel tenant;
    private UserModel buyer;
    private TicketModel ticket;
    private Double sellingPrice;
    private LocalDateTime transactionDate;
    private String transactionStatus;

    public Long getTransactionId() {
        return this.transactionId;
    }

    public void setTransactionId(Long transactionId) {
        this.transactionId = transactionId;
    }

    public TenantModel getTenant() {
        return this.tenant;
    }

    public void setTenant(TenantModel tenant) {
        this.tenant = tenant;
    }

    public UserModel getBuyer() {
        return this.buyer;
    }

    public void setBuyer(UserModel buyer) {
        this.buyer = buyer;
    }

    public TicketModel getTicket() {
        return this.ticket;
    }

    public void setTicket(TicketModel ticket) {
        this.ticket = ticket;
    }

    public Double getSellingPrice() {
        return this.sellingPrice;
    }

    public void setSellingPrice(Double sellingPrice) {
        this.sellingPrice = sellingPrice;
    }

    public LocalDateTime getTransactionDate() {
        return this.transactionDate;
    }

    public void setTransactionDate(LocalDateTime transactionDate) {
        this.transactionDate = transactionDate;
    }

    public String getTransactionStatus() {
        return this.transactionStatus;
    }

    public void setTransactionStatus(String transactionStatus) {
        this.transactionStatus = transactionStatus;
    }

}
