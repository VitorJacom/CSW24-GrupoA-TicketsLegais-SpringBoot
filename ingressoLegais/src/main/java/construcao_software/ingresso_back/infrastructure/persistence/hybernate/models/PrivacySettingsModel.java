package construcao_software.ingresso_back.infrastructure.persistence.hybernate.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "privacy_settings")
public class PrivacySettingsModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "privacy_settings_id")
    private Long privacySettingsId;

    @OneToOne
    @JoinColumn(name = "user_id", nullable = false)
    private UserModel user;

    @Column(nullable = false)
    private boolean allowDataSharing;

    @Column(nullable = false)
    private String profileVisibility;

    @Column(nullable = false)
    private boolean transactionHistoryVisibility;

    @Column(nullable = false)
    private boolean allowMarketingCommunications;
}
