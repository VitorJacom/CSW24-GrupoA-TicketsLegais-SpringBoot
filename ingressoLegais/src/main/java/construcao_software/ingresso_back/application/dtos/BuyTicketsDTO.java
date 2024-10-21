package construcao_software.ingresso_back.application.dtos;

import java.util.Collection;

public record BuyTicketsDTO(
        Long userId,
        Collection<Long> ticketIds
)
{
}
