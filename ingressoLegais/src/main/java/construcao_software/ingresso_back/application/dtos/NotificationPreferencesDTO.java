package construcao_software.ingresso_back.application.dtos;

import lombok.Data;

@Data
public class NotificationPreferencesDTO {

    private Long preferencesId;
    private UserDTO user;
    private boolean allowEmailNotifications;
    private boolean allowPushNotifications;
}
