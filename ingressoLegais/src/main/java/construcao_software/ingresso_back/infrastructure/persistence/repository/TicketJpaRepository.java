package construcao_software.ingresso_back.infrastructure.persistence.repository;

import construcao_software.ingresso_back.domain.entities.TicketEntity;
import construcao_software.ingresso_back.domain.enums.TicketStatus;
import construcao_software.ingresso_back.infrastructure.persistence.hybernate.models.TicketModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
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

    List<TicketModel> findByUserId(Long userId);

    @Query("SELECT t FROM TicketModel t WHERE t.seller.id = :sellerId AND t.status = :status")
    List<TicketModel> findBySellerIdAndStatus(Long sellerId, TicketStatus status);
}
