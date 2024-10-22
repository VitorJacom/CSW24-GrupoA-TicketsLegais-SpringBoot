package construcao_software.ingresso_back.application.dtos;

import lombok.Data;

@Data
public class UserDTO {
    
    private Long userId;
    private String name;
    private String email;
    private String firebaseToken;
    private TenantDTO tenant;
    private PrivacySettingsDTO privacySettings;
}
