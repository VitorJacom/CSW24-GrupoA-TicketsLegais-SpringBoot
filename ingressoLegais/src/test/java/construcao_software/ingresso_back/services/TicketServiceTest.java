package construcao_software.ingresso_back.services;

import construcao_software.ingresso_back.application.dtos.*;
import construcao_software.ingresso_back.adapter.persistence.hybernate.models.TicketModel;
import construcao_software.ingresso_back.adapter.persistence.repository.TicketJpaRepository;
import construcao_software.ingresso_back.application.mappers.TicketMapper;
import construcao_software.ingresso_back.application.services.TicketService;
import construcao_software.ingresso_back.domain.enums.TicketStatus;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class TicketServiceTest {

    @Mock
    private TicketJpaRepository repository;

    @Mock
    private TicketMapper mapper;

    @InjectMocks
    private TicketService service;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void shouldGetAllByEventId() {
        Long eventId = 1L;
        List<TicketModel> models = List.of(new TicketModel());
        List<TicketDTO> dtos = List.of(new TicketDTO());

        when(repository.getAllByEvent_EventId(eventId)).thenReturn(models);
        when(mapper.toDTO(any(TicketModel.class))).thenReturn(dtos.get(0));

        List<TicketDTO> result = service.getAllByEventId(eventId);

        assertEquals(1, result.size());
        verify(repository).getAllByEvent_EventId(eventId);
    }
}
