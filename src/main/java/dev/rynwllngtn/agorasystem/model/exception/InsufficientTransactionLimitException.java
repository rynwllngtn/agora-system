package dev.rynwllngtn.agorasystem.model.exception;

public class InsufficientTransactionLimitException extends DomainException {
    public InsufficientTransactionLimitException(String message) {
        super(message);
    }
}
