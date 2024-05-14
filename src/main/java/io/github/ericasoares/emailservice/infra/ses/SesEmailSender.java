package io.github.ericasoares.emailservice.infra.ses;

import com.amazonaws.AmazonServiceException;
import com.amazonaws.services.simpleemail.AmazonSimpleEmailService;
import com.amazonaws.services.simpleemail.model.*;
import io.github.ericasoares.emailservice.adapters.EmailSenderOnBound;
import io.github.ericasoares.emailservice.core.exceptions.EmailServiceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SesEmailSender implements EmailSenderOnBound {

    private final AmazonSimpleEmailService amazonService;

    @Autowired
    public SesEmailSender(AmazonSimpleEmailService amazonService){
        this.amazonService = amazonService;
    }

    @Override
    public void sendEmail(String toEmail, String subject, String message) {
        SendEmailRequest request = new SendEmailRequest()
                .withSource("meu email conta amazon validado no ses")
                .withDestination(new Destination().withToAddresses(toEmail))
                .withMessage(new Message()
                        .withSubject(new Content(subject))
                        .withBody(new Body().withText(new Content(message)))
                );
        try {
            amazonService.sendEmail(request);
        }catch (AmazonServiceException ex){
            throw new EmailServiceException("Failure while sending email", ex);
        }
    }
}
