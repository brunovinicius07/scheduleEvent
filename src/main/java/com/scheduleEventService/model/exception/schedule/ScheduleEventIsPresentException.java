package com.scheduleEventService.model.exception.schedule;

import com.scheduleEventService.model.exception.exceptionHandler.AlertException;
import org.springframework.http.HttpStatus;

public class ScheduleEventIsPresentException extends AlertException {

    private static final String DEFAULT_MESSAGE = "Já existe um evento para esse dia e horário";

    public ScheduleEventIsPresentException() {
        super("409", DEFAULT_MESSAGE, HttpStatus.CONFLICT);
    }
}