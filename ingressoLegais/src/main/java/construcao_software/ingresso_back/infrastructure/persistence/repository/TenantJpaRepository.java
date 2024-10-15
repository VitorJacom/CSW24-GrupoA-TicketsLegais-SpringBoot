package construcao_software.ingresso_back.infrastructure.persistence.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import construcao_software.ingresso_back.infrastructure.persistence.hybernate.models.TenantModel;

public interface TenantJpaRepository extends JpaRepository<TenantModel, Long>{
    
}
