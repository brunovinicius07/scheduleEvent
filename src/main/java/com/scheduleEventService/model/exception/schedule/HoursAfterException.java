package com.scheduleEventService.model.exception.schedule;

import com.scheduleEventService.model.exception.exceptionHandler.AlertException;
import org.springframework.http.HttpStatus;

public class HoursAfterException extends AlertException {

    private static final String DEFAULT_MESSAGE = "O horário de início deve ser antes do horário de encerramento.";

    public HoursAfterException() {
        super("409", DEFAULT_MESSAGE, HttpStatus.CONFLICT);
    }
}