package com.scheduleEventService.model.exception.schedule;

import com.scheduleEventService.model.exception.exceptionHandler.AlertException;
import org.springframework.http.HttpStatus;

public class ScheduleEventNotFoundException extends AlertException {
    private static final String DEFAULT_MESSAGE = "Evento não localizado";
    public ScheduleEventNotFoundException() {
        super("404", DEFAULT_MESSAGE, HttpStatus.NOT_FOUND);

    }
}
