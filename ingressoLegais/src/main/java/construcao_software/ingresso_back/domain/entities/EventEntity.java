package construcao_software.ingresso_back.domain.entities;

import construcao_software.ingresso_back.adapter.persistence.hybernate.models.TenantModel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class EventEntity {   
    private Long eventId;
    private TenantModel tenant;
    private String eventName;
    private String type;
    private String location;
    private LocalDateTime dateTime;
}
