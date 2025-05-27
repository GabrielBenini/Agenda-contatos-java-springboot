package com.gabriel.nova_agenda_contatos.exceptions;

public class EmailJaExistenteException extends RuntimeException {
    public EmailJaExistenteException(String message) {
        super(message);
    }
}
