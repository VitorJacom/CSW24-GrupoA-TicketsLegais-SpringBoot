package construcao_software.ingresso_back.domain.entities;

import java.time.LocalDateTime;

import construcao_software.ingresso_back.infrastructure.persistence.hybernate.models.TenantModel;

public class EventEntity {
    
    private Long eventoId;
    private TenantModel tenant;
    private String nomeDoEvento;
    private String tipo;
    private String localizacao;
    private LocalDateTime dataEHora;

    public Long getEventoId() {
        return eventoId;
    }

    public void setEventoId(Long eventoId) {
        this.eventoId = eventoId;
    }

    public TenantModel getTenant() {
        return tenant;
    }

    public void setTenant(TenantModel tenant) {
        this.tenant = tenant;
    }

    public String getNomeDoEvento() {
        return nomeDoEvento;
    }

    public void setNomeDoEvento(String nomeDoEvento) {
        this.nomeDoEvento = nomeDoEvento;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getLocalizacao() {
        return localizacao;
    }

    public void setLocalizacao(String localizacao) {
        this.localizacao = localizacao;
    }

    public LocalDateTime getDataEHora() {
        return dataEHora;
    }

    public void setDataEHora(LocalDateTime dataEHora) {
        this.dataEHora = dataEHora;
    }
    
}
