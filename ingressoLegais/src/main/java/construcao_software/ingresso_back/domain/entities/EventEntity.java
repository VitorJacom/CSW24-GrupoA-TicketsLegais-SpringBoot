package construcao_software.ingresso_back.domain.entities;

import java.time.LocalDateTime;

import construcao_software.ingresso_back.infrastructure.persistence.hybernate.models.TenantModel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class EventEntity {   
    private Long eventId;
    private TenantModel tenant;
    private String eventName;
    private String type;
    private String localization;
    private LocalDateTime dateTime;
}
