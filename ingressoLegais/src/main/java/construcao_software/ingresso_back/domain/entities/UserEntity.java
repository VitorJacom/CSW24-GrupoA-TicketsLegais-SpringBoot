package construcao_software.ingresso_back.domain.entities;

import construcao_software.ingresso_back.infrastructure.persistence.hybernate.models.PrivacySettings;
import construcao_software.ingresso_back.infrastructure.persistence.hybernate.models.TenantModel;

public class UserEntity {
    
    private Long userId;
    private TenantModel tenant;
    private String nome;
    private String email;
    private String firebaseToken;
    private PrivacySettings configuracoesDePrivacidade;

    public Long getUserId() {
        return this.userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public TenantModel getTenant() {
        return this.tenant;
    }

    public void setTenant(TenantModel tenant) {
        this.tenant = tenant;
    }

    public String getNome() {
        return this.nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFirebaseToken() {
        return this.firebaseToken;
    }

    public void setFirebaseToken(String firebaseToken) {
        this.firebaseToken = firebaseToken;
    }

    public PrivacySettings getConfiguracoesDePrivacidade() {
        return this.configuracoesDePrivacidade;
    }

    public void setConfiguracoesDePrivacidade(PrivacySettings configuracoesDePrivacidade) {
		this.configuracoesDePrivacidade = configuracoesDePrivacidade;
	}
}