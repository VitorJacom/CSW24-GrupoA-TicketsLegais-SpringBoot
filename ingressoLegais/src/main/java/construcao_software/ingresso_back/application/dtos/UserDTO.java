package construcao_software.ingresso_back.application.dtos;

import lombok.Data;

@Data
public class UserDTO {
    
    private Long userId;
    private TenantDTO tenant;
    private String name;
    private String email;
    private String firebaseToken;
    private NotificationPreferencesDTO notificationPreferences;
}
