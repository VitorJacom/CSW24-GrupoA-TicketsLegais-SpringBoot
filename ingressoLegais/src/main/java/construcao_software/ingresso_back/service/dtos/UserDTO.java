package construcao_software.ingresso_back.service.dtos;

import construcao_software.ingresso_back.infrastructure.persistence.hybernate.models.PrivacySettingsModel;
import construcao_software.ingresso_back.infrastructure.persistence.hybernate.models.TenantModel;
import lombok.Data;

@Data
public class UserDTO {
    
    private Long userId;
    private TenantModel tenant;
    private String nome;
    private String email;
    private String firebaseToken;
    private PrivacySettingsModel configuracoesDePrivacidade;
}
