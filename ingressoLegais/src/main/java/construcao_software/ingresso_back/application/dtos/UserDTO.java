package construcao_software.ingresso_back.application.dtos;

import construcao_software.ingresso_back.infrastructure.persistence.hybernate.models.PrivacySettingsModel;
import lombok.Data;

@Data
public class UserDTO {
    
    private Long userId;
    private TenantDTO tenant;
    private String name;
    private String email;
    private String firebaseToken;
    private PrivacySettingsModel privacySettings;
}
