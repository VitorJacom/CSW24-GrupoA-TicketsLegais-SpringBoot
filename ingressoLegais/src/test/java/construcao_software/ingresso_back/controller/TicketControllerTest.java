package construcao_software.ingresso_back.controller;

import construcao_software.ingresso_back.adapter.controller.TicketController;
import construcao_software.ingresso_back.application.dtos.*;
import construcao_software.ingresso_back.application.services.TicketService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.ResponseEntity;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class TicketControllerTest {

    @Mock
    private TicketService service;

    @InjectMocks
    private TicketController controller;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void shouldGetAllTicketsByEventId() {
        Long eventId = 1L;
        List<TicketDTO> dtos = List.of(new TicketDTO());

        when(service.getAllByEventId(eventId)).thenReturn(dtos);

        ResponseEntity<List<TicketDTO>> response = controller.getAllByEventId(eventId);

        assertNotNull(response);
        assertEquals(1, response.getBody().size());
        verify(service).getAllByEventId(eventId);
    }

    @Test
    void shouldSellTicket() {
        CreateTicketDTO createDTO = new CreateTicketDTO(1L, 1L, 100.0);
        TicketDTO dto = new TicketDTO();

        when(service.sellTicket(createDTO)).thenReturn(dto);

        ResponseEntity<TicketDTO> response = controller.sellTicket(createDTO);

        assertNotNull(response);
        assertEquals(201, response.getStatusCode().value());
        verify(service).sellTicket(createDTO);
    }
}
