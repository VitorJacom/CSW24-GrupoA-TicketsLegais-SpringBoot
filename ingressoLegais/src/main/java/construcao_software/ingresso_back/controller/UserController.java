package construcao_software.ingresso_back.controller;

import construcao_software.ingresso_back.application.dtos.UserDTO;
import construcao_software.ingresso_back.application.mappers.UserMapper;
import construcao_software.ingresso_back.application.services.UserService;
import construcao_software.ingresso_back.application.usecases.GetUserBalanceUC;
import construcao_software.ingresso_back.application.usecases.GetUserSoldTickets;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
@RequiredArgsConstructor
public class UserController {

    private final UserService service;

    private final GetUserBalanceUC getUserBalanceUC;

    @GetMapping("/")
    public ResponseEntity<List<UserDTO>> getAllUsers() {
        List<UserDTO> users = service.getAll();
        return ResponseEntity.ok(users);
    }

    @GetMapping("/{userId}/saldo")
    public ResponseEntity<Double> getBalance(@PathVariable Long userId) {
        return ResponseEntity.ok(getUserBalanceUC.run(userId));
    }
}
