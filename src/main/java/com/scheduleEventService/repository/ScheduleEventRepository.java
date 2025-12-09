package com.scheduleEventService.repository;

import com.scheduleEventService.model.entity.ScheduleEvent;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

public interface ScheduleEventRepository extends MongoRepository<ScheduleEvent, String> {

    Optional<ScheduleEvent> findByUserIdAndDayAndOpening(Long userId, LocalDate day, LocalDateTime opening);

    List<ScheduleEvent> findByUserId(Long userId);
}

