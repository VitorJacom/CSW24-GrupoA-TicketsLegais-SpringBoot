package construcao_software.ingresso_back.application.dtos;

import construcao_software.ingresso_back.domain.entities.TenantEntity;
import lombok.Data;

@Data
public class EventDTO {
 
    private Long eventId;
    private TenantEntity tenant;
    private String eventName;
    private String type;
    private String location;
    private String dateTime;
}
