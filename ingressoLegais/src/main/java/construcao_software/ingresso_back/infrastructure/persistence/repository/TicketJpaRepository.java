package construcao_software.ingresso_back.infrastructure.persistence.repository;

import construcao_software.ingresso_back.domain.base.TicketStatus;
import construcao_software.ingresso_back.infrastructure.persistence.hybernate.models.TicketModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

@Repository
public interface TicketJpaRepository extends JpaRepository<TicketModel, Long> {

    List<TicketModel> getAllByEvent_EventId(Long eventId);

    Optional<TicketModel> findByUniqueVerificationCode(String uniqueVerificationCode);

    Collection<TicketModel> getAllBySeller_UserId(Long sellerId);

    Optional<TicketModel> getAllBySeller_UserIdAndStatus(Long seller_userId, TicketStatus status);
}
