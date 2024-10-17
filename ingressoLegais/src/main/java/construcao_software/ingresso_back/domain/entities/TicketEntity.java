package construcao_software.ingresso_back.domain.entities;

import construcao_software.ingresso_back.infrastructure.persistence.hybernate.models.EventModel;
import construcao_software.ingresso_back.infrastructure.persistence.hybernate.models.TenantModel;
import construcao_software.ingresso_back.infrastructure.persistence.hybernate.models.UserModel;

public class TicketEntity {

    private Long ticketId;
    private EventModel event;
    private TenantModel tenant;
    private Double originalPrice;
    private UserModel seller;
    private String uniqueVerificationCode;
    private String status;

    public Long getTicketId() {
        return this.ticketId;
    }

    public void setTicketId(Long ticketId) {
        this.ticketId = ticketId;
    }

    public EventModel getEvent() {
        return this.event;
    }

    public void setEvent(EventModel event) {
        this.event = event;
    }

    public TenantModel getTenant() {
        return this.tenant;
    }

    public void setTenant(TenantModel tenant) {
        this.tenant = tenant;
    }

    public Double getOriginalPrice() {
        return this.originalPrice;
    }

    public void setOriginalPrice(Double originalPrice) {
        this.originalPrice = originalPrice;
    }

    public UserModel getSeller() {
        return this.seller;
    }

    public void setSeller(UserModel seller) {
        this.seller = seller;
    }

    public String getUniqueVerificationCode() {
        return this.uniqueVerificationCode;
    }

    public void setUniqueVerificationCode(String uniqueVerificationCode) {
        this.uniqueVerificationCode = uniqueVerificationCode;
    }

    public String getStatus() {
        return this.status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    
}
