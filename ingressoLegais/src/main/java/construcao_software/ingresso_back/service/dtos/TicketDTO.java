package construcao_software.ingresso_back.service.dtos;

import construcao_software.ingresso_back.infrastructure.persistence.hybernate.models.EventModel;
import construcao_software.ingresso_back.infrastructure.persistence.hybernate.models.TenantModel;
import construcao_software.ingresso_back.infrastructure.persistence.hybernate.models.UserModel;
import lombok.Data;

@Data
public class TicketDTO {

    private Long ticketId;
    private EventModel event;
    private TenantModel tenant;
    private Double originalPrice;
    private UserModel seller;
    private String uniqueVerificationCode;
    private String status;
}
