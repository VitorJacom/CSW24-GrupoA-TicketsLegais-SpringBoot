package construcao_software.ingresso_back.infrastructure.persistence.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import construcao_software.ingresso_back.infrastructure.persistence.hybernate.models.TransactionModel;

public interface TransactionJpaRepository extends JpaRepository<TransactionModel, Long> {
	
}
