package construcao_software.ingresso_back.adapter.persistence.repository;

import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import construcao_software.ingresso_back.adapter.persistence.hybernate.models.EventModel;

@Repository
public interface EventJpaRepository extends JpaRepository<EventModel, Long> {
    // Aqui você pode adicionar métodos de consulta personalizados, se necessário

    @Query("SELECT e FROM EventModel e WHERE e.eventName LIKE %:eventName%")
    Collection<EventModel> getAllByFilterName(@Param("eventName") String eventName);

}