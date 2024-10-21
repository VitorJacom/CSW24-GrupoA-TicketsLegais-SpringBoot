package construcao_software.ingresso_back.service.dtos;

import java.time.LocalDateTime;

import construcao_software.ingresso_back.infrastructure.persistence.hybernate.models.TenantModel;
import lombok.Data;

@Data
public class EventDTO {
 
    private Long eventoId;
    private TenantModel tenant;
    private String nomeDoEvento;
    private String tipo;
    private String localizacao;
    private LocalDateTime dataEHora;
}
