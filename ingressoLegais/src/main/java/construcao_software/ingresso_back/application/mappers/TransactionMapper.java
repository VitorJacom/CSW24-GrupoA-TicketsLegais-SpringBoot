package construcao_software.ingresso_back.application.mappers;

import org.modelmapper.ModelMapper;
import org.modelmapper.spi.MappingContext;
import org.springframework.stereotype.Component;

import construcao_software.ingresso_back.domain.entities.TenantEntity;
import construcao_software.ingresso_back.domain.entities.TransactionEntity;
import construcao_software.ingresso_back.infrastructure.persistence.hybernate.models.TenantModel;
import construcao_software.ingresso_back.infrastructure.persistence.hybernate.models.TransactionModel;
import construcao_software.ingresso_back.application.dtos.TransactionDTO;

import org.modelmapper.Converter;

@Component
public class TransactionMapper {

    private final ModelMapper modelMapper;

    public TransactionMapper() {
        this.modelMapper = new ModelMapper();

        // Mapeamento personalizado de TenantModel para TenantEntity
        this.modelMapper.typeMap(TenantModel.class, TenantEntity.class).setConverter(new Converter<TenantModel, TenantEntity>() {
            public TenantEntity convert(MappingContext<TenantModel, TenantEntity> context) {
                TenantModel source = context.getSource();
                if (source == null) {
                    return null;
                }
                TenantEntity tenantEntity = new TenantEntity();
                tenantEntity.setId(source.getTenantId()); // Supondo que você tenha um método getter para tenantId
                tenantEntity.setName(source.getName());
                tenantEntity.setContactInformation(source.getContactInformation());
                tenantEntity.setSpecificConfigurations(source.getSpecificConfigurations());
                return tenantEntity;
            }
        });

        // Mapeamento para TransactionEntity
        this.modelMapper.typeMap(TransactionModel.class, TransactionEntity.class).setConverter(new Converter<TransactionModel, TransactionEntity>() {
            public TransactionEntity convert(MappingContext<TransactionModel, TransactionEntity> context) {
                TransactionModel source = context.getSource();
                if (source == null) {
                    return null;
                }
                TransactionEntity transactionEntity = new TransactionEntity();
                transactionEntity.setTransactionId(source.getTransactionId());
                transactionEntity.setSellingPrice(source.getSellingPrice());
                transactionEntity.setTransactionDate(source.getTransactionDate());
                transactionEntity.setTransactionStatus(source.getTransactionStatus());

                // Mapeia o TenantModel para TenantEntity
                if (source.getTenant() != null) {
                    transactionEntity.setTenant(modelMapper.map(source.getTenant(), TenantEntity.class));
                }

                // Mapeia o BuyerModel e TicketModel se necessário
                // if (source.getBuyer() != null) {
                //     transactionEntity.setBuyer(modelMapper.map(source.getBuyer(), UserEntity.class));
                // }
                // if (source.getTicket() != null) {
                //     transactionEntity.setTicket(modelMapper.map(source.getTicket(), TicketEntity.class));
                // }

                return transactionEntity;
            }
        });
    }

    // Convert Model to Entity
    public TransactionEntity toEntity(TransactionModel model) {
        return modelMapper.map(model, TransactionEntity.class);
    }

    // Convert DTO to Entity
    public TransactionEntity toEntity(TransactionDTO dto) {
        return modelMapper.map(dto, TransactionEntity.class);
    }

    // Convert Entity to Model
    public TransactionModel toModel(TransactionEntity entity) {
        return modelMapper.map(entity, TransactionModel.class);
    }

    // Convert DTO to Model
    public TransactionModel toModel(TransactionDTO dto) {
        return modelMapper.map(dto, TransactionModel.class);
    }

    // Convert Entity to DTO
    public TransactionDTO toDTO(TransactionEntity entity) {
        return modelMapper.map(entity, TransactionDTO.class);
    }

    // Convert Model to DTO
    public TransactionDTO toDTO(TransactionModel model) {
        return modelMapper.map(model, TransactionDTO.class);
    }
    
}