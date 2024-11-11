package construcao_software.ingresso_back.adapter.persistence.hybernate.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "event")
public class EventModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "event_id")
    private Long eventId;

    @ManyToOne
    @JoinColumn(name = "tenant_id", nullable = false)
    private TenantModel tenant;

    @Column(nullable = false)
    private String eventName;

    @Column
    private String type;

    @Column
    private String location;

    @Column
    private LocalDateTime dateTime;
}
