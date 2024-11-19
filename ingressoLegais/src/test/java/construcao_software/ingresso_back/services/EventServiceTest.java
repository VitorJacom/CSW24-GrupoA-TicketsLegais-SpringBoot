package construcao_software.ingresso_back.services;

import construcao_software.ingresso_back.adapter.persistence.hybernate.models.EventModel;
import construcao_software.ingresso_back.adapter.persistence.repository.EventJpaRepository;
import construcao_software.ingresso_back.application.dtos.EventDTO;
import construcao_software.ingresso_back.application.mappers.EventMapper;
import construcao_software.ingresso_back.application.services.EventService;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class EventServiceTest {

    @Mock
    private EventJpaRepository repository;

    @Mock
    private EventMapper mapper;

    @InjectMocks
    private EventService service;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void shouldGetAllEvents() {
        List<EventModel> models = List.of(new EventModel());
        List<EventDTO> dtos = List.of(new EventDTO());

        when(repository.findAll()).thenReturn(models);
        when(mapper.toDTO(any(EventModel.class))).thenReturn(dtos.get(0));

        List<EventDTO> result = service.getAllEvents();

        assertNotNull(result);
        assertEquals(1, result.size());
        verify(repository).findAll();
    }

    @Test
    void shouldGetEventById() {
        Long eventId = 1L;
        EventModel model = new EventModel();
        EventDTO dto = new EventDTO();

        when(repository.findById(eventId)).thenReturn(Optional.of(model));
        when(mapper.toDTO(model)).thenReturn(dto);

        Optional<EventDTO> result = service.getEventByID(eventId);

        assertTrue(result.isPresent());
        verify(repository).findById(eventId);
    }

    @Test
    void shouldCreateEvent() {
        EventDTO dto = new EventDTO();
        EventModel model = new EventModel();

        when(mapper.toModel(dto)).thenReturn(model);
        when(repository.save(model)).thenReturn(model);
        when(mapper.toDTO(model)).thenReturn(dto);

        EventDTO result = service.createEvent(dto);

        assertNotNull(result);
        verify(repository).save(model);
    }

    @Test
    void shouldUpdateEvent() {
        Long eventId = 1L;
        EventDTO dto = new EventDTO();
        EventModel model = new EventModel();

        when(repository.findById(eventId)).thenReturn(Optional.of(model));
        when(mapper.toModel(dto)).thenReturn(model);
        when(repository.save(model)).thenReturn(model);
        when(mapper.toDTO(model)).thenReturn(dto);

        Optional<EventDTO> result = service.updateEvent(eventId, dto);

        assertTrue(result.isPresent());
        verify(repository).save(model);
    }

    @Test
    void shouldDeleteEvent() {
        Long eventId = 1L;
        EventModel model = new EventModel();

        when(repository.findById(eventId)).thenReturn(Optional.of(model));

        boolean result = service.deleteEvent(eventId);

        assertTrue(result);
        verify(repository).delete(model);
    }

    @Test
    void shouldReturnFalseWhenEventToDeleteDoesNotExist() {
        Long eventId = 1L;

        when(repository.findById(eventId)).thenReturn(Optional.empty());

        boolean result = service.deleteEvent(eventId);

        assertFalse(result);
        verify(repository, never()).delete(any());
    }
}
