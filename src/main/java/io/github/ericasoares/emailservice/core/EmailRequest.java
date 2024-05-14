package io.github.ericasoares.emailservice.core;

public record EmailRequest(String to, String subject, String message) {

}
