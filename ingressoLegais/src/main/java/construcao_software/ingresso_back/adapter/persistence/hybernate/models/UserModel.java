package construcao_software.ingresso_back.adapter.persistence.hybernate.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "user")
public class UserModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private Long userId;

    @ManyToOne
    @JoinColumn(name = "tenant_id", nullable = false)
    private TenantModel tenant;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false, unique = true)
    private String email;

    @Column
    private String firebaseToken;

    @OneToOne
    @JoinColumn(name = "notification_preferences_id")
    private NotificationPreferencesModel notificationPreferences;
}