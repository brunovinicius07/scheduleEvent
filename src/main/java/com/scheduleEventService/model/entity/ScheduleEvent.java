package com.scheduleEventService.model.entity;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "schedule_events")
public class ScheduleEvent {

    @Id
    private String id;

    private Long userId;

    private LocalDate day;

    private LocalDateTime opening;

    private LocalDateTime closure;

    private String title;

    private String description;
}
