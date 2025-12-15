package com.scheduleEventService.controller;

import com.scheduleEventService.model.dto.request.ScheduleEventRequest;
import com.scheduleEventService.model.dto.response.ScheduleEventResponse;
import com.scheduleEventService.service.ScheduleEventService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("v1/schedule/event")
public class ScheduleEventController {

    private final ScheduleEventService scheduleEventService;

    @PostMapping("/post")
    public ResponseEntity<ScheduleEventResponse> registerEvent(
            @RequestBody @Valid ScheduleEventRequest scheduleEventRequest) {

        ScheduleEventResponse response = scheduleEventService.createEvent(scheduleEventRequest);

        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @GetMapping("/get/{userId}")
    public ResponseEntity<List<ScheduleEventResponse>> getAllScheduleEventByUserId(
            @PathVariable Long userId) {

        List<ScheduleEventResponse> response = scheduleEventService.getAllScheduleEventByIdUser(userId);

        return ResponseEntity.ok(response);
    }

    @GetMapping("/day")
    public ResponseEntity<List<ScheduleEventResponse>> getEventsByUserAndDay(@RequestParam Long userId,
                                                                      @RequestParam LocalDate day) {
        return ResponseEntity.ok(
                scheduleEventService.getEventsByUserAndDay(userId, day)
        );
    }

    @GetMapping("/month")
    public ResponseEntity<List<Integer>> getDaysWithEventsInMonth(@RequestParam Long userId,
                                                                  @RequestParam int year,
                                                                  @RequestParam int month) {
        return ResponseEntity.ok(
                scheduleEventService.getDaysWithEventsInMonth(userId, year, month)
        );
    }

    @GetMapping("/range")
    public ResponseEntity<List<ScheduleEventResponse>> getEventsByRange(@RequestParam Long userId,
                                                                        @RequestParam LocalDate start,
                                                                        @RequestParam LocalDate end) {
        return ResponseEntity.ok(
                scheduleEventService.getEventsByRange(userId, start, end)
        );
    }

    @PutMapping("/put/{id}")
    public ResponseEntity<ScheduleEventResponse> updateScheduleEvent(
            @PathVariable String id,
            @RequestBody @Valid ScheduleEventRequest scheduleEventRequest) {

        ScheduleEventResponse response = scheduleEventService.updateScheduleEvent(id, scheduleEventRequest);

        return ResponseEntity.ok(response);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteScheduleEvent(@PathVariable String id) {

        String message = scheduleEventService.deleteScheduleEvent(id);

        return ResponseEntity.ok(message);
    }
}
