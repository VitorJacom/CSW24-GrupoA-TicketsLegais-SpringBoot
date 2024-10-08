package construcao_software.ingresso_back.infrastructure.persistence.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "transacao")
public class Transacao {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "transacao_id")
    private Long transacaoId;

    @ManyToOne
    @JoinColumn(name = "tenant_id", nullable = false)
    private Tenant tenant;

    @ManyToOne
    @JoinColumn(name = "id_do_comprador")
    private Usuario comprador;

    @OneToOne
    @JoinColumn(name = "id_do_ticket", nullable = false)
    private Ticket ticket;

    @Column(nullable = false)
    private Double precoDeVenda;

    @Column(nullable = false)
    private LocalDateTime dataDaTransacao;

    @Column(nullable = false)
    private String statusDaTransacao;
}
