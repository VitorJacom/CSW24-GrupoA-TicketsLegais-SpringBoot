package construcao_software.ingresso_back.application.dtos;

import construcao_software.ingresso_back.infrastructure.persistence.hybernate.models.UserModel;
import lombok.Data;

@Data
public class NotificationPreferencesDTO {
    
    private Long preferencesId;
    private UserModel user;
    private boolean allowEmailNotifications;
    private boolean allowPushNotifications;   
}
