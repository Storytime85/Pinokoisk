package com.storytime.pinokoiskmainapp.mappers.impl.simple;

import com.storytime.pinokoiskmainapp.dto.simple.ProfessionDto;
import com.storytime.pinokoiskmainapp.entities.simple.ProfessionEntity;
import com.storytime.pinokoiskmainapp.mappers.Mapper;
import org.springframework.stereotype.Component;

@Component
public class ProfessionMapper implements Mapper<ProfessionEntity, ProfessionDto> {


    @Override
    public ProfessionDto mapTo(ProfessionEntity professionEntity) {
        return new ProfessionDto(professionEntity.getId(), professionEntity.getProfession());

    }

    @Override
    public ProfessionEntity mapFrom(ProfessionDto professionDto) {
        //TODO: доделать
        return null;
    }
}
