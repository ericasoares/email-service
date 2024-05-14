package io.github.ericasoares.emailservice.core.usecases;

public interface EmailSenderUseCase {
    void sendEmail(String to, String subject, String message);
}
