package construcao_software.ingresso_back.domain.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PrivacySettingsEntity {
    
    private Long privacySettingsId;
    private Long userId;
    private boolean allowDataSharing;
    private String profileVisibility;
    private boolean transactionHistoryVisibility;
    private boolean allowMarketingCommunications;
}
