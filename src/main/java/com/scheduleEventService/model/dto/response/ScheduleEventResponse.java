package com.scheduleEventService.model.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ScheduleEventResponse {

    private String id;

    private Long userId;

    private LocalDate day;

    private LocalDateTime opening;

    private LocalDateTime closure;

    private String title;

    private String description;
}
