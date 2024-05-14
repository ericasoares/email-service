package io.github.ericasoares.emailservice.application;

import io.github.ericasoares.emailservice.adapters.EmailSenderOnBound;
import io.github.ericasoares.emailservice.core.usecases.EmailSenderUseCase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmailSenderService implements EmailSenderUseCase {

    private final EmailSenderOnBound emailSenderOnBound;

    @Autowired
    public EmailSenderService(EmailSenderOnBound emailSenderOnBound){
        this.emailSenderOnBound = emailSenderOnBound;
    }

    @Override
    public void sendEmail(String to, String subject, String message) {
        this.emailSenderOnBound.sendEmail(to, subject, message);
    }
}
