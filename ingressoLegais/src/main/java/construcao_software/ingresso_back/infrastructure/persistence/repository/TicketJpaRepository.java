package construcao_software.ingresso_back.infrastructure.persistence.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import construcao_software.ingresso_back.infrastructure.persistence.hybernate.models.TicketModel;

@Repository
public interface TicketJpaRepository extends JpaRepository<TicketModel, Long> {
    // Aqui você pode adicionar métodos de consulta personalizados, se necessário

    @Query("SELECT t FROM TicketModel t WHERE t.eventId = ?1")
    List<TicketModel> getAllByEventId(Long eventId);

}
