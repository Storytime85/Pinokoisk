package com.storytime.pinokoiskmainapp.mappers.impl.simple;

import com.storytime.pinokoiskmainapp.dto.simple.AgeRestrictionsDto;
import com.storytime.pinokoiskmainapp.entities.simple.AgeRestrictionsEntity;
import com.storytime.pinokoiskmainapp.mappers.Mapper;
import org.springframework.stereotype.Component;

@Component
public class AgeRestrictionsMapper implements Mapper<AgeRestrictionsEntity, AgeRestrictionsDto> {
    @Override
    public AgeRestrictionsDto mapTo(AgeRestrictionsEntity ageRestrictionsEntity) {
        return new AgeRestrictionsDto(ageRestrictionsEntity.getId(), ageRestrictionsEntity.getRestrictions());
    }

    @Override
    public AgeRestrictionsEntity mapFrom(AgeRestrictionsDto ageRestrictionsDto) {
        return null;
    }
}
