package com.scheduleEventService.service.impl;

import com.scheduleEventService.model.dto.request.ScheduleEventRequest;
import com.scheduleEventService.model.dto.response.ScheduleEventResponse;
import com.scheduleEventService.model.entity.ScheduleEvent;
import com.scheduleEventService.model.exception.schedule.*;
import com.scheduleEventService.model.mapper.ScheduleEventMapper;
import com.scheduleEventService.repository.ScheduleEventRepository;
import com.scheduleEventService.service.ScheduleEventService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ScheduleEventServiceImpl implements ScheduleEventService {

    private final ScheduleEventRepository repository;
    private final ScheduleEventMapper scheduleEventMapper;

    @Override
    public ScheduleEventResponse createEvent(ScheduleEventRequest request) {

        validateDayAndTimeOfEvent(request);

        existingScheduleEvent(request.getUserId(), request.getDay(), request.getOpening());

        ScheduleEvent scheduleEvent = scheduleEventMapper.toScheduleEvent(request);

        return scheduleEventMapper.toScheduleEventResponseDto(repository.save(scheduleEvent));
    }

    @Override
    public List<ScheduleEventResponse> getAllScheduleEventByIdUser(Long userId) {
        List<ScheduleEvent> events = repository.findByUserId(userId);

        if (events.isEmpty()) {
            throw new ScheduleEventNotFoundException();
        }

        return scheduleEventMapper.toScheduleEventsResponse(events);
    }

    @Override
    public ScheduleEventResponse updateScheduleEvent(String id, ScheduleEventRequest request) {
        ScheduleEvent scheduleEvent = validateScheduleEvent(id);

        if (request.getOpening() != null && request.getClosure() != null) {
            validateDayAndTimeOfEvent(request);
        }

        if (request.getDay() != null) scheduleEvent.setDay(request.getDay());
        if (request.getOpening() != null) scheduleEvent.setOpening(request.getOpening());
        if (request.getClosure() != null) scheduleEvent.setClosure(request.getClosure());
        if (request.getTitle() != null) scheduleEvent.setTitle(request.getTitle());

        scheduleEvent.setDescription(request.getDescription());

        return scheduleEventMapper.toScheduleEventResponseDto(repository.save(scheduleEvent));
    }

    @Override
    public String deleteScheduleEvent(String id) {
        ScheduleEvent event = validateScheduleEvent(id);
        repository.delete(event);
        return "Evento deletado!";
    }

    @Override
    public void validateDayAndTimeOfEvent(ScheduleEventRequest request) {
        LocalDate day = request.getDay();
        LocalDateTime opening = request.getOpening();
        LocalDateTime closure = request.getClosure();

        if (!opening.toLocalDate().isEqual(day)) {
            throw new DayToStartEventException();
        }

        if (!(closure.toLocalDate().isEqual(day) ||
                closure.toLocalDate().isEqual(day.plusDays(1)))) {
            throw new DayFinishEventException();
        }

        if (opening.isAfter(closure) || opening.isEqual(closure)) {
            throw new HoursAfterException();
        }
    }

    @Override
    public void existingScheduleEvent(Long userId, LocalDate day, LocalDateTime opening) {
        repository.findByUserIdAndDayAndOpening(userId, day, opening)
                .ifPresent(s -> {
                    throw new ScheduleEventIsPresentException();
                });
    }

    @Override
    public ScheduleEvent validateScheduleEvent(String id) {
        return repository.findById(id)
                .orElseThrow(ScheduleEventNotFoundException::new);
    }
}

