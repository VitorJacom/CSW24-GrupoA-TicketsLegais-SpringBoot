package construcao_software.ingresso_back.adapter.handler;

import construcao_software.ingresso_back.application.dtos.ErrorDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.reactive.function.client.WebClientException;
import org.springframework.web.reactive.function.client.WebClientRequestException;
import org.springframework.web.reactive.function.client.WebClientResponseException;

@RequiredArgsConstructor
@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(Throwable.class)
    public ResponseEntity<ErrorDTO> handle(Throwable e) {
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body(new ErrorDTO(
                        String.valueOf(HttpStatus.INTERNAL_SERVER_ERROR.value()),
                        "Erro interno do servidor.",
                        e.getMessage()
                ));
    }

    @ExceptionHandler(WebClientException.class)
    public ResponseEntity<ErrorDTO> handle(WebClientRequestException e) {
        ErrorDTO errorDTO = new ErrorDTO(
                String.valueOf(HttpStatus.BAD_REQUEST.value()),
                "Requisição inválida. Verifique os parâmetros.",
                e.getMessage()
        );

        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorDTO);
    }

    @ExceptionHandler(WebClientResponseException.class)
    public ResponseEntity<ErrorDTO> handle(WebClientResponseException e) {
        return ResponseEntity.status(HttpStatus.valueOf(e.getStatusCode().value()))
                .body(new ErrorDTO(
                        String.valueOf(e.getStatusCode().value()),
                        handleStatusCode(e.getStatusCode()),
                        e.getResponseBodyAsString()
                ));
    }

    private String handleStatusCode(HttpStatusCode status) {

        return switch (HttpStatus.valueOf(status.value())) {
            case BAD_REQUEST -> "Requisição inválida. Verifique os parâmetros.";
            case UNAUTHORIZED -> "Não autorizado. Verifique suas credenciais.";
            case FORBIDDEN -> "Acesso proibido. Você não tem permissão para esta ação.";
            case NOT_FOUND -> "Recurso não encontrado.";
            case INTERNAL_SERVER_ERROR -> "Erro interno do servidor.";
            case CONFLICT -> "Conflito.";
            default -> "Erro desconhecido.";
        };

    }
}

