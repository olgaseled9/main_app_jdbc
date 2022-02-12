package com.seledtsova.exception;

import com.seledtsova.exception.DaoException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class DaoExceptionTest {

    @Test
    void shouldThrowException() {
        Throwable exception = assertThrows(DaoException.class, () ->
        {
            throw new DaoException("a message");
        });
        assertEquals("a message", exception.getMessage());
    }

}