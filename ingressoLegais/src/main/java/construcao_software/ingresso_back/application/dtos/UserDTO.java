package construcao_software.ingresso_back.application.dtos;

import construcao_software.ingresso_back.infrastructure.persistence.hybernate.models.PrivacySettingsModel;
import construcao_software.ingresso_back.infrastructure.persistence.hybernate.models.TenantModel;
import lombok.Data;

@Data
public class UserDTO {
    
    private Long userId;
    private TenantModel tenant;
    private String name;
    private String email;
    private String firebaseToken;
    private PrivacySettingsModel privacySettings;
}
