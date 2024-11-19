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

    @Test
    void shouldSellTicket() {
        CreateTicketDTO createDTO = new CreateTicketDTO(1L, 1L, 100.0);
        TicketModel model = new TicketModel();
        TicketDTO dto = new TicketDTO();

        // Ajustando o método chamado
        when(mapper.toModelFromEntity(any())).thenReturn(model);
        when(repository.save(model)).thenReturn(model);
        when(mapper.toDTO(model)).thenReturn(dto);

        TicketDTO result = service.sellTicket(createDTO);

        assertNotNull(result);
        verify(repository).save(model);
    }

    @Test
    void shouldThrowExceptionWhenTicketNotAvailable() {
        BuyTicketsDTO buyDTO = new BuyTicketsDTO(1L, List.of(1L));
        TicketDTO ticketDTO = new TicketDTO();
        ticketDTO.setStatus(TicketStatus.SOLD);

        when(service.getTicketById(1L)).thenReturn(Optional.of(ticketDTO));

        Exception exception = assertThrows(RuntimeException.class, () -> {
            service.processTicketSale(buyDTO);
        });

        assertEquals("Ticket not available: 1", exception.getMessage());
    }
}
