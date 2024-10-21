package construcao_software.ingresso_back.controller;

import construcao_software.ingresso_back.application.dtos.TicketDTO;
import construcao_software.ingresso_back.application.dtos.UserDTO;
import construcao_software.ingresso_back.application.mappers.UserMapper;
import construcao_software.ingresso_back.application.services.UserService;
import construcao_software.ingresso_back.application.usecases.GetUserBalanceUC;
import construcao_software.ingresso_back.application.usecases.GetUserSoldTickets;
import construcao_software.ingresso_back.domain.enums.TicketStatus;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/users")
@RequiredArgsConstructor
public class UserController {

    private final UserService service;
    private final UserMapper mapper;

    private final GetUserBalanceUC getUserBalanceUC;
    private final GetUserSoldTickets getUserSoldTickets;

    @GetMapping("/")
    public ResponseEntity<List<UserDTO>> getAllUsers() {
        List<UserDTO> users = service.getAll().stream()
                .map(mapper::toDTO)
                .collect(Collectors.toList());
        return ResponseEntity.ok(users);
    }

    @GetMapping("/{userId}/saldo")
    public ResponseEntity<Double> getBalance(@PathVariable Long userId) {
        return ResponseEntity.ok(getUserBalanceUC.run(userId));
    }

    @GetMapping("/{userId}/tickets")
    public ResponseEntity<Collection<TicketDTO>> getAllTickets(@PathVariable Long userId, @RequestParam(required = false) TicketStatus status) {
        return ResponseEntity.ok(getUserSoldTickets.run(userId, status));
    }
}
