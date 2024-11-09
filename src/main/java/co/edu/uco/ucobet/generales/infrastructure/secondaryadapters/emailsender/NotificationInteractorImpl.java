package co.edu.uco.ucobet.generales.infrastructure.secondaryadapters.emailsender;

import co.edu.uco.ucobet.generales.application.secondaryports.emailsender.NotificationInteractor;
import co.edu.uco.ucobet.generales.application.secondaryports.redis.MessageCatalog;
import com.azure.identity.DefaultAzureCredentialBuilder;
import com.azure.security.keyvault.secrets.SecretClient;
import com.azure.security.keyvault.secrets.SecretClientBuilder;
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

    private final SecretClient secretClient;
    private final MessageCatalog messageCatalog;

    public NotificationInteractorImpl(@Value("${azure.keyvault.url}") String keyVaultUrl, MessageCatalog messageCatalog) {
        this.secretClient = new SecretClientBuilder()
                .vaultUrl(keyVaultUrl)  // Usa la URL desde el properties
                .credential(new DefaultAzureCredentialBuilder().build())
                .buildClient();
        this.messageCatalog = messageCatalog;
    }

    private String getMailerSendApiKey() {
        return secretClient.getSecret("mailsenderapi1").getValue();
    }

    private String getMailerSendEmail() {
        return secretClient.getSecret("ecobetmail").getValue();
    }

    private String getMailerSendDestinationEmail() {
        return secretClient.getSecret("email").getValue();
    }

    @Override
    public void notifySuccess(String subject, String message) {
        MailerSend mailerSend = new MailerSend();
        mailerSend.setToken(getMailerSendApiKey());

        Email email = new Email();
        email.setFrom("UCOBET", getMailerSendEmail());
        email.addRecipient("Cristian Quiroz", getMailerSendDestinationEmail());
        email.setSubject(subject);
        email.setPlain(message);
        email.setHtml("<p>" + message + "</p>");

        try {
            MailerSendResponse response = mailerSend.emails().send(email);
            logger.info("Email sent successfully with ID: {}", response.messageId);
        } catch (MailerSendException e) {
            logger.error(messageCatalog.getMessageOrDefault("MailerSendException"), e);
        }
    }
}