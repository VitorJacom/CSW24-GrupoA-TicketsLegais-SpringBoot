package construcao_software.ingresso_back.infrastructure.persistence.hybernate.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "notification_preferences")
public class NotificationPreferencesModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "preferences_id")
    private Long preferencesId;

    @OneToOne
    @JoinColumn(name = "user_id", nullable = false)
    private UserModel user;

    @Column(nullable = false)
    private boolean allowEmailNotifications;

    @Column(nullable = false)
    private boolean allowPushNotifications;
}
