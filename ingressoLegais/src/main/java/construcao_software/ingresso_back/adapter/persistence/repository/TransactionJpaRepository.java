package construcao_software.ingresso_back.adapter.persistence.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import construcao_software.ingresso_back.adapter.persistence.hybernate.models.TransactionModel;

@Repository
public interface TransactionJpaRepository extends JpaRepository<TransactionModel, Long> {
    List<TransactionModel> findByTenant_TenantId(Long tenantId);
    List<TransactionModel> findByBuyer_UserId(Long userId); 
    List<TransactionModel> findAllByBuyer_UserId(Long userId);
}
