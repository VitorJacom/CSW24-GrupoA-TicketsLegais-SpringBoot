package construcao_software.ingresso_back.infrastructure.persistence.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "configuracoes_de_privacidade")
public class ConfiguracoesDePrivacidade {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "configuracoes_de_privacidade_id")
    private Long configuracoesDePrivacidadeId;

    @OneToOne
    @JoinColumn(name = "user_id", nullable = false)
    private Usuario usuario;

    @Column(nullable = false)
    private boolean permitirCompartilhamentoDados;

    @Column(nullable = false)
    private String visibilidadePerfil;

    @Column(nullable = false)
    private boolean historicoDeTransacoesVisivel;

    @Column(nullable = false)
    private boolean receberComunicacoesMarketing;
}
