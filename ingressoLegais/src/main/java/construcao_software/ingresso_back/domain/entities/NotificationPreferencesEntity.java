package construcao_software.ingresso_back.domain.entities;

import construcao_software.ingresso_back.infrastructure.persistence.hybernate.models.UserModel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class NotificationPreferencesEntity {
    private Long preferencesId;
    private UserModel user;
    private boolean allowEmailNotifications;
    private boolean allowPushNotifications;
}
