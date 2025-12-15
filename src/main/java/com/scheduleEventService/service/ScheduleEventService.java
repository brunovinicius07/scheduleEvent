package com.scheduleEventService.service;


import com.scheduleEventService.model.dto.request.ScheduleEventRequest;
import com.scheduleEventService.model.dto.response.ScheduleEventResponse;
import com.scheduleEventService.model.entity.ScheduleEvent;
import org.jspecify.annotations.Nullable;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

public interface ScheduleEventService {

    ScheduleEventResponse createEvent(ScheduleEventRequest request);

    List<ScheduleEventResponse> getAllScheduleEventByIdUser(Long userId);

    List<ScheduleEventResponse> getEventsByUserAndDay(Long userId, LocalDate day);

    List<Integer> getDaysWithEventsInMonth(Long userId, int year, int month);

    List<ScheduleEventResponse> getEventsByRange(Long userId, LocalDate start, LocalDate end);

    ScheduleEventResponse updateScheduleEvent(String idScheduleEvent, ScheduleEventRequest request);

    String deleteScheduleEvent(String idScheduleEvent);

    void existingScheduleEvent(Long userId, LocalDate day, LocalDateTime opening);

    ScheduleEvent validateScheduleEvent(String idScheduleEvent);

    void validateDayAndTimeOfEvent(ScheduleEventRequest request);
}

