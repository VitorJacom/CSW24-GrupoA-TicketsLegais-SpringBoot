package construcao_software.ingresso_back.domain.entities;

import construcao_software.ingresso_back.infrastructure.persistence.hybernate.models.PrivacySettingsModel;
import construcao_software.ingresso_back.infrastructure.persistence.hybernate.models.TenantModel;
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
    private TenantModel tenant;
    private String nome;
    private String email;
    private String firebaseToken;
    private PrivacySettingsModel configuracoesDePrivacidade;
}
