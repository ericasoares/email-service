package io.github.ericasoares.emailservice.adapters;

public interface EmailSenderOnBound {
    void sendEmail(String to, String subject, String message);
}
