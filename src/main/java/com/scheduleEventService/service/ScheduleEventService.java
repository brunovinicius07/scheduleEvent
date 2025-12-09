package com.scheduleEventService.service;


import com.scheduleEventService.model.dto.request.ScheduleEventRequest;
import com.scheduleEventService.model.dto.response.ScheduleEventResponse;
import com.scheduleEventService.model.entity.ScheduleEvent;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

public interface ScheduleEventService {

    ScheduleEventResponse createEvent(ScheduleEventRequest request);

    List<ScheduleEventResponse> getAllScheduleEventByIdUser(Long userId);

    ScheduleEventResponse updateScheduleEvent(String idScheduleEvent, ScheduleEventRequest request);

    String deleteScheduleEvent(String idScheduleEvent);

    void existingScheduleEvent(Long userId, LocalDate day, LocalDateTime opening);

    ScheduleEvent validateScheduleEvent(String idScheduleEvent);

    void validateDayAndTimeOfEvent(ScheduleEventRequest request);
}

