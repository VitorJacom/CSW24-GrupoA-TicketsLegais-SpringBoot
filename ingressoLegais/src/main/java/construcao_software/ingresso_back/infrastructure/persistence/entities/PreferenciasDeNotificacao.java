package construcao_software.ingresso_back.infrastructure.persistence.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "preferencias_de_notificacao")
public class PreferenciasDeNotificacao {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "preferencias_id")
    private Long preferenciasId;

    @OneToOne
    @JoinColumn(name = "user_id", nullable = false)
    private Usuario usuario;

    @Column(nullable = false)
    private boolean receberEmails;

    @Column(nullable = false)
    private boolean receberPushNotifications;
}
