package construcao_software.ingresso_back.application.services;

import construcao_software.ingresso_back.application.dtos.BuyTicketsDTO;
import construcao_software.ingresso_back.application.dtos.CreateTicketDTO;
import construcao_software.ingresso_back.application.dtos.EventDTO;
import construcao_software.ingresso_back.application.dtos.TicketDTO;
import construcao_software.ingresso_back.application.dtos.TransactionDTO;
import construcao_software.ingresso_back.application.dtos.UserDTO;
import construcao_software.ingresso_back.application.mappers.EventMapper;
import construcao_software.ingresso_back.application.mappers.TicketMapper;
import construcao_software.ingresso_back.application.mappers.UserMapper;
import construcao_software.ingresso_back.domain.entities.EventEntity;
import construcao_software.ingresso_back.domain.entities.TicketEntity;
import construcao_software.ingresso_back.domain.entities.UserEntity;
import construcao_software.ingresso_back.domain.enums.TicketStatus;
import construcao_software.ingresso_back.adapter.persistence.hybernate.models.TicketModel;
import construcao_software.ingresso_back.adapter.persistence.repository.TicketJpaRepository;

import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class TicketService {

    private TicketJpaRepository repository;
    private UserService userService;
    private EventService eventService;
    private TransactionService transactionService;
    private TicketMapper mapper;
    private EventMapper eventMapper;
    private UserMapper userMapper;

    public TicketService(TicketJpaRepository repository,
                         UserService userService,
                         EventService eventService,
                         TransactionService transactionService,
                         TicketMapper mapper,
                         EventMapper eventMapper,
                         UserMapper userMapper) {
        this.repository = repository;
        this.userService = userService;
        this.eventService = eventService;
        this.transactionService = transactionService;
        this.mapper = mapper;
        this.eventMapper = eventMapper;
        this.userMapper = userMapper;
    }

    public List<TicketDTO> getAllByEventId(Long eventId) {
        return repository.getAllByEvent_EventId(eventId).stream()
                .map(mapper::toDTO)
                .collect(Collectors.toList());
    }

    public TicketDTO createTicket(TicketDTO ticket) {
        TicketModel saved = repository.save(mapper.toModel(ticket));
        return mapper.toDTO(saved);
    }

    public Collection<TicketDTO> getAllBySellerId(Long sellerId, TicketStatus status) {
        if (status == null) {
            return repository.getAllBySeller_UserId(sellerId).stream()
                    .map(mapper::toDTO)
                    .collect(Collectors.toList());
        }
        return repository.getAllBySeller_UserIdAndStatus(sellerId, status).stream()
                .map(mapper::toDTO)
                .collect(Collectors.toList());
    }

    public Optional<TicketDTO> getTicketById(Long ticketId) {
        return repository.findById(ticketId).map(mapper::toDTO);
    }

    public Collection<TicketDTO> processTicketSale(BuyTicketsDTO buyTicketsDTO) {

        UserDTO userDTO = userService.getUserByID(buyTicketsDTO.userId())
                .orElseThrow(() -> new RuntimeException("User not found"));

        ArrayList<TransactionDTO> transactions = new ArrayList<>();
        ArrayList<TicketDTO> ticketDTOs = new ArrayList<>();

        for (Long ticketID : buyTicketsDTO.ticketIds()) {
            TicketDTO ticketDTO = this.getTicketById(ticketID)
                    .orElseThrow(() -> new RuntimeException("Ticket not found"));

            if (!ticketDTO.getStatus().equals(TicketStatus.AVAILABLE))
                throw new RuntimeException("Ticket not available: " + ticketID);

            TransactionDTO transactionDTO = transactionService.createTransaction(ticketDTO, userDTO);
            transactions.add(transactionDTO);

            ticketDTO.setStatus(TicketStatus.SOLD);
            ticketDTO.setTenant(userDTO.getTenant());

            ticketDTOs.add(ticketDTO);

        }

        ArrayList<TicketDTO> saved = new ArrayList<>();
        for (TicketDTO save : ticketDTOs) {
            TicketModel ticketModel = mapper.toModel(save);
            ticketModel = repository.save(ticketModel);
            saved.add(mapper.toDTO(ticketModel));
        }

        return saved;
    }

    public TicketDTO sellTicket(CreateTicketDTO createTicketDTO) {

        UserDTO seller = userService.getUserByID(createTicketDTO.sellerId())
                .orElseThrow(() -> new RuntimeException("Seller not found"));

        EventDTO event = eventService.getEventByID(createTicketDTO.eventId())
                .orElseThrow(() -> new RuntimeException("Event not found"));

        EventEntity eventEntity = eventMapper.toEntity(event);
        UserEntity sellerEntity = userMapper.toEntity(seller);

        TicketEntity ticket = new TicketEntity();
        ticket.setOriginalPrice(createTicketDTO.originalPrice());
        ticket.setEvent(eventEntity);
        ticket.setSeller(sellerEntity);
        ticket.setStatus(TicketStatus.AVAILABLE);
        ticket.setUniqueVerificationCode(UUID.randomUUID().toString());

        TicketModel ticketModel = repository.save(mapper.toModel(ticket));

        return createTicket(mapper.toDTO(ticketModel));
    }

    public TicketDTO validateAndUseTicket(String ticketCode) {
        TicketModel ticketModel = repository.findByUniqueVerificationCode(ticketCode)
                .orElseThrow(() -> new RuntimeException("Ticket not found"));

        TicketStatus statusAtual = ticketModel.getStatus();

        // Verifica se o ingresso está com status SOLD
        if (statusAtual != TicketStatus.SOLD) {
            throw new RuntimeException("Ingresso não pode ser usado. Status atual: " + statusAtual);
        }

        // Marca o ingresso como USADO
        ticketModel.setStatus(TicketStatus.USED);

        // Salva a atualização no banco de dados
        TicketModel savedTicket = repository.save(ticketModel);

        // Retorna o DTO atualizado
        return mapper.toDTO(savedTicket);
    }

    public List<TicketDTO> getTicketsByTenantId(Long userId) {
        return repository.getAllByTenant_TenantId(userId).stream()
                .map(mapper::toDTO)
                .collect(Collectors.toList());
    }
}
