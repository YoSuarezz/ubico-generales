package co.edu.uco.ucobet.generales.infrastructure.secondaryadapters.emailsender;

import co.edu.uco.ucobet.generales.application.secondaryports.emailsender.NotificationInteractor;
import com.mailersend.sdk.MailerSend;
import com.mailersend.sdk.MailerSendResponse;
import com.mailersend.sdk.emails.Email;
import com.mailersend.sdk.exceptions.MailerSendException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class NotificationInteractorImpl implements NotificationInteractor {

    private static final Logger logger = LoggerFactory.getLogger(NotificationInteractorImpl.class);

    @Value("${spring.mailersend.api-key}")
    private String mailerSendApiKey;

    @Value("${spring.mailersend.email}")
    private String mailerSendEmail;

    @Value("${spring.mailersend.destination.email}")
    private String mailerSendDestinationEmail;

    @Override
    public void notifySuccess(String subject, String message) {
        MailerSend mailerSend = new MailerSend();
        mailerSend.setToken(mailerSendApiKey);

        Email email = new Email();
        email.setFrom("UCOBET", mailerSendEmail);
        email.addRecipient("Cristian Quiroz", mailerSendDestinationEmail);
        email.setSubject(subject);
        email.setPlain(message);
        email.setHtml("<p>" + message + "</p>");

        try {
            MailerSendResponse response = mailerSend.emails().send(email);
            logger.info("Email sent successfully with ID: {}", response.messageId);
        } catch (MailerSendException e) {
            logger.error("Failed to send email", e);
        }
    }
}