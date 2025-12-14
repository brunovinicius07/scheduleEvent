package com.scheduleEventService.model.mapper;

import com.scheduleEventService.model.dto.request.ScheduleEventRequest;
import com.scheduleEventService.model.dto.response.ScheduleEventResponse;
import com.scheduleEventService.model.entity.ScheduleEvent;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ScheduleEventMapper {


    ScheduleEvent toScheduleEvent(ScheduleEventRequest scheduleEventRequestDto);

    ScheduleEventResponse toScheduleEventResponseDto(ScheduleEvent scheduleEvent);

    List<ScheduleEventResponse> toScheduleEventsResponse(List<ScheduleEvent> scheduleEventList);
}
