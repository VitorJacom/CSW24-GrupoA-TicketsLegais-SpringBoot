package construcao_software.ingresso_back.domain.entities;

import construcao_software.ingresso_back.adapter.persistence.hybernate.models.UserModel;
import lombok.*;

@Data
public class NotificationPreferencesEntity {
    private Long preferencesId;
    private UserModel user;
    private boolean allowEmailNotifications;
    private boolean allowPushNotifications;
}
