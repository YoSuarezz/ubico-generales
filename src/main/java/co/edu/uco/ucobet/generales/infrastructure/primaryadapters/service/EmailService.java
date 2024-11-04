package co.edu.uco.ucobet.generales.infrastructure.primaryadapters.service;
import com.mailersend.sdk.MailerSend;
import com.mailersend.sdk.MailerSendResponse;
import com.mailersend.sdk.exceptions.MailerSendException;
import com.mailersend.sdk.emails.Email;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;


import com.mailersend.sdk.MailerSend;
import com.mailersend.sdk.MailerSendResponse;
import com.mailersend.sdk.exceptions.MailerSendException;
import com.mailersend.sdk.emails.Email;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class EmailService {

    @Value("${spring.mailersend.api-key}")
    private String mailerSendApiKey;

    @Value("${spring.mailersend.email}")
    private String mailerSendEmail;

    @Value("${spring.mailersend.destination.email}")
    private String mailerSendDestinationEmail;

    public void sendSuccessEmail(String subject, String text) {
        MailerSend ms = new MailerSend();
        ms.setToken(mailerSendApiKey);

        Email email = new Email();
        email.setFrom("UCOBET", mailerSendEmail);
        email.addRecipient("Cristian Quiroz", mailerSendDestinationEmail);
        email.setSubject(subject);
        email.setPlain(text);
        email.setHtml("<p>" + text + "</p>");

        try {
            MailerSendResponse response = ms.emails().send(email);
            System.out.println(response.messageId);
        } catch (MailerSendException e) {
            e.printStackTrace();
        }
    }
}