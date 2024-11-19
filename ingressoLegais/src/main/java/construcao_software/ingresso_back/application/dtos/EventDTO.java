package construcao_software.ingresso_back.application.dtos;

import lombok.Data;

@Data
public class EventDTO {
 
    private Long eventId;
    private TenantDTO tenant;
    private String eventName;
    private String type;
    private String location;
    private String dateTime;
}
