package construcao_software.ingresso_back.adapter.persistence.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import construcao_software.ingresso_back.adapter.persistence.hybernate.models.UserModel;

@Repository
public interface UserJpaRepository extends JpaRepository<UserModel, Long> {

}
