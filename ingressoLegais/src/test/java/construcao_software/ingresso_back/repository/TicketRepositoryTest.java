package construcao_software.ingresso_back.repository;

import construcao_software.ingresso_back.adapter.persistence.hybernate.models.TicketModel;
import construcao_software.ingresso_back.adapter.persistence.repository.TicketJpaRepository;
import construcao_software.ingresso_back.domain.enums.TicketStatus;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
class TicketJpaRepositoryTest {

    @Autowired
    private TicketJpaRepository repository;

    @Test
    void shouldFindAllByEventId() {
        TicketModel ticket = new TicketModel();
        ticket.setOriginalPrice(100.0);
        ticket.setStatus(TicketStatus.AVAILABLE);
        ticket.setUniqueVerificationCode("CODE123");

        repository.save(ticket);

        List<TicketModel> tickets = repository.getAllByEvent_EventId(ticket.getEvent().getEventId());

        assertEquals(1, tickets.size());
    }
}
