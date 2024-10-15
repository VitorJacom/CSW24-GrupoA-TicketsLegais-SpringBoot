package construcao_software.ingresso_back.service.dtos;

import lombok.Data;

@Data
public class PrivacySettingsDTO {
    
    private Long privacySettingsId;
    private Long userId;
    private boolean allowDataSharing;
    private String profileVisibility;
    private boolean transactionHistoryVisibility;
    private boolean allowMarketingCommunications;
}
