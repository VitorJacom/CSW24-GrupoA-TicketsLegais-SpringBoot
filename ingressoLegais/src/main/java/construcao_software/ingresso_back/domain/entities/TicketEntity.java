package construcao_software.ingresso_back.domain.entities;

import construcao_software.ingresso_back.infrastructure.persistence.hybernate.models.EventModel;
import construcao_software.ingresso_back.infrastructure.persistence.hybernate.models.TenantModel;
import construcao_software.ingresso_back.infrastructure.persistence.hybernate.models.UserModel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class TicketEntity {
    private Long ticketId;
    private EventModel event;
    private TenantModel tenant;
    private Double originalPrice;
    private UserModel seller;
    private String uniqueVerificationCode;
    private String status;
}
