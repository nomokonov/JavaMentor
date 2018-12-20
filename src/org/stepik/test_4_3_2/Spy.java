package org.stepik.test_4_3_2;

import java.util.logging.ConsoleHandler;
import java.util.logging.Handler;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Spy implements MailService {
    private static final Logger logger = Logger.getLogger(MailService.class.getName());

    public Spy() {
        logger.setLevel(Level.ALL);
        Handler handler = new ConsoleHandler();
        handler.setLevel(Level.ALL);
        logger.addHandler(handler);
    }

    @Override
    public Sendable processMail(Sendable mail) {
        if ( mail instanceof MailMessage){
            if ( mail.getTo().equals("Austin Powers") || mail.getFrom().equals("Austin Powers")){
                logger.log(Level.WARNING,"Detected target mail correspondence: from {from} to {to} \"{message}\"",mail.getFrom(),mail.getTo(),((MailMessage) mail).getMessage());
            } else {
                logger.log(Level.INFO,"Usual correspondence: from {from} to {to}",mail.getFrom(),mail.getTo());
            }
        }
        return mail;
    }
}
