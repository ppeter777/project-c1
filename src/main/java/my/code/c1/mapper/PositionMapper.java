package my.code.c1.mapper;

import my.code.c1.dto.PositionDTO;
import my.code.c1.model.Position;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.MappingConstants;
import org.mapstruct.NullValuePropertyMappingStrategy;
import org.mapstruct.ReportingPolicy;

@Mapper(uses = {JsonNullableMapper.class, ReferenceMapper.class},
        nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE,
        componentModel = MappingConstants.ComponentModel.SPRING,
        unmappedTargetPolicy = ReportingPolicy.IGNORE)

public abstract class PositionMapper {

    public abstract Position map(PositionDTO model);

    public abstract PositionDTO map(Position task);

    public abstract void update(PositionDTO data, @MappingTarget Position destination);
}
