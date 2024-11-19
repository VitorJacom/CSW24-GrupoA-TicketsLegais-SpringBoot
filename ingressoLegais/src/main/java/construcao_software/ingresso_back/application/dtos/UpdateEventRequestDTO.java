package construcao_software.ingresso_back.application.dtos;

public class UpdateEventRequestDTO {
    private Long id;
    private EventDTO eventDTO;

    public UpdateEventRequestDTO(Long id, EventDTO eventDTO) {
        this.id = id;
        this.eventDTO = eventDTO;
    }

    // Getters e Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public EventDTO getEventDTO() {
        return eventDTO;
    }

    public void setEventDTO(EventDTO eventDTO) {
        this.eventDTO = eventDTO;
    }
}
