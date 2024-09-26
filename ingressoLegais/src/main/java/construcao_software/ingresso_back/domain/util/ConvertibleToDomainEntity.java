package construcao_software.ingresso_back.domain.util;

import jakarta.annotation.Nonnull;

public interface ConvertibleToDomainEntity<EntityType, DTOType>
{
	@Nonnull
	DTOType toDomainEntity(EntityType Entity);
	EntityType fromDomainEntity();
}