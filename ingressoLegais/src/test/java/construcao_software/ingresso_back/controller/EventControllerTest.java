package construcao_software.ingresso_back.controller;

import construcao_software.ingresso_back.adapter.controller.EventController;
import construcao_software.ingresso_back.application.dtos.EventDTO;
import construcao_software.ingresso_back.application.services.EventService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.ResponseEntity;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class EventControllerTest {

    @Mock
    private EventService service;

    @InjectMocks
    private EventController controller;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void shouldGetAllEvents() {
        List<EventDTO> events = List.of(new EventDTO());

        when(service.getAllEvents()).thenReturn(events);

        ResponseEntity<Collection<EventDTO>> response = controller.getAllEvents();

        assertNotNull(response);
        assertEquals(200, response.getStatusCode().value());
        assertEquals(1, response.getBody().size());
        verify(service).getAllEvents();
    }

    @Test
    void shouldGetEventById() {
        Long eventId = 1L;
        EventDTO eventDTO = new EventDTO();

        when(service.getEventByID(eventId)).thenReturn(Optional.of(eventDTO));

        ResponseEntity<Optional<EventDTO>> response = controller.getEventById(eventId);

        assertNotNull(response);
        assertEquals(200, response.getStatusCode().value());
        assertTrue(response.getBody().isPresent());
        verify(service).getEventByID(eventId);
    }

    @Test
    void shouldReturnNotFoundForNonExistentEvent() {
        Long eventId = 1L;

        when(service.getEventByID(eventId)).thenReturn(Optional.empty());

        ResponseEntity<Optional<EventDTO>> response = controller.getEventById(eventId);

        assertEquals(404, response.getStatusCode().value());
        verify(service).getEventByID(eventId);
    }

    @Test
    void shouldCreateEvent() {
        EventDTO eventDTO = new EventDTO();

        when(service.createEvent(eventDTO)).thenReturn(eventDTO);

        ResponseEntity<EventDTO> response = controller.createEvent(eventDTO);

        assertNotNull(response);
        assertEquals(201, response.getStatusCode().value());
        verify(service).createEvent(eventDTO);
    }

    @Test
    void shouldUpdateEvent() {
        Long eventId = 1L;
        EventDTO eventDTO = new EventDTO();

        when(service.updateEvent(eventId, eventDTO)).thenReturn(Optional.of(eventDTO));

        ResponseEntity<EventDTO> response = controller.updateEvent(eventId, eventDTO);

        assertNotNull(response);
        assertEquals(200, response.getStatusCode().value());
        verify(service).updateEvent(eventId, eventDTO);
    }

    @Test
    void shouldReturnNotFoundWhenUpdatingNonExistentEvent() {
        Long eventId = 1L;
        EventDTO eventDTO = new EventDTO();

        when(service.updateEvent(eventId, eventDTO)).thenReturn(Optional.empty());

        ResponseEntity<EventDTO> response = controller.updateEvent(eventId, eventDTO);

        assertEquals(404, response.getStatusCode().value());
        verify(service).updateEvent(eventId, eventDTO);
    }

    @Test
    void shouldDeleteEvent() {
        Long eventId = 1L;

        when(service.deleteEvent(eventId)).thenReturn(true);

        ResponseEntity<Void> response = controller.deleteEvent(eventId);

        assertEquals(204, response.getStatusCode().value());
        verify(service).deleteEvent(eventId);
    }

    @Test
    void shouldReturnNotFoundWhenDeletingNonExistentEvent() {
        Long eventId = 1L;

        when(service.deleteEvent(eventId)).thenReturn(false);

        ResponseEntity<Void> response = controller.deleteEvent(eventId);

        assertEquals(404, response.getStatusCode().value());
        verify(service).deleteEvent(eventId);
    }
}
