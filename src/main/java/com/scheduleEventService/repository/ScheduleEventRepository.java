package com.scheduleEventService.repository;

import com.scheduleEventService.model.entity.ScheduleEvent;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

public interface ScheduleEventRepository extends MongoRepository<ScheduleEvent, String> {

    Optional<ScheduleEvent> findByUserIdAndDayAndOpening(Long userId, LocalDate day, LocalDateTime opening);

    List<ScheduleEvent> findByUserId(Long userId);

    List<ScheduleEvent> findEventsByUserIdAndDay(Long userId, LocalDate day);

    Optional<ScheduleEvent> findByUserIdAndDayAndOpeningAndIdNot(Long userId, LocalDate day, LocalDateTime opening,
                                                                 String id
    );

    @Query("{ 'userId': ?0, 'day': { $gte: ?1, $lte: ?2 } }")
    List<ScheduleEvent> findEventsByUserIdAndDayBetween(Long userId, LocalDate start, LocalDate end);
}

