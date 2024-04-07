package com.storytime.pinokoiskmainapp.mappers.impl.simple;

import com.storytime.pinokoiskmainapp.dto.simple.StreamingDto;
import com.storytime.pinokoiskmainapp.entities.simple.StreamingEntity;
import com.storytime.pinokoiskmainapp.mappers.Mapper;
import org.springframework.stereotype.Component;

@Component
public class StreamingMapper implements Mapper<StreamingEntity, StreamingDto> {


    @Override
    public StreamingDto mapTo(StreamingEntity streamingEntity) {
        if (streamingEntity == null) {
            return null;
        } else {
            return new StreamingDto(streamingEntity.getId(), streamingEntity.getStreamingService());
        }
    }

    @Override
    public StreamingEntity mapFrom(StreamingDto streamingDto) {
        return null;

    }
}
