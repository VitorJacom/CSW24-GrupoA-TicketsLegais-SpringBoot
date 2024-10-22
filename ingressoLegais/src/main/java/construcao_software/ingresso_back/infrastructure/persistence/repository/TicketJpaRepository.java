package construcao_software.ingresso_back.infrastructure.persistence.repository;

import construcao_software.ingresso_back.domain.entities.TicketEntity;
import construcao_software.ingresso_back.domain.enums.TicketStatus;
import construcao_software.ingresso_back.infrastructure.persistence.hybernate.models.TicketModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
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

    @Query("SELECT t FROM TicketModel t WHERE t.seller.userId = :sellerId")
    List<TicketModel> findByUser(@Param("sellerId") Long sellerId);

    @Query("SELECT t FROM TicketModel t WHERE t.seller.userId = :sellerId AND t.status = :status")
    List<TicketModel> findBySellerIdAndStatus(@Param("sellerId") Long sellerId, @Param("status") TicketStatus status);
}
