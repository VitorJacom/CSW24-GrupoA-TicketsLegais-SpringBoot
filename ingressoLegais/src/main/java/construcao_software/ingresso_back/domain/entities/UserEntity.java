package construcao_software.ingresso_back.domain.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UserEntity {    
    private Long userId;
    private TenantEntity tenant;
    private String name;
    private String email;
    private String firebaseToken;
    private NotificationPreferencesEntity notificationPreferences;
}
