package org.stepik.test_4_3_2;

import java.util.logging.*;

public class Main {
    public static final String AUSTIN_POWERS = "Austin Powers";
    public static final String WEAPONS = "weapons";
    public static final String BANNED_SUBSTANCE = "banned substance";

    public static void main(String[] args) {

        long start = System.nanoTime();
        // поиск смысла жизни ...
        int a = 12;
        String s = String.valueOf(a);

        long finish = System.nanoTime();
        long timeConsumedMillis = finish - start;
        System.out.println(timeConsumedMillis);
    }

    public static class UntrustworthyMailWorker implements MailService {
        MailService[] mailServices;
        RealMailService realMailService = new RealMailService();

        public UntrustworthyMailWorker(MailService[] mailServices) {
            this.mailServices = mailServices;
        }

        @Override
        public Sendable processMail(Sendable mail) {
            Sendable sendable = mail;
            for (int i = 0; i < mailServices.length; i++) {
                sendable = mailServices[i].processMail(sendable);
            }
            return realMailService.processMail(sendable);
        }

        public RealMailService getRealMailService() {
            return realMailService;
        }

    }

    public static class Spy implements MailService {
        private static Logger logger;

        public Spy(Logger logger) {
            this.logger = logger;
        }

        @Override
        public Sendable processMail(Sendable mail) {
            if (mail instanceof MailMessage) {
                if (mail.getTo().equals(AUSTIN_POWERS) || mail.getFrom().equals(AUSTIN_POWERS)) {
                    logger.log(Level.WARNING, "Detected target mail correspondence: from {0} to {1} \"{2}\"",
                            new Object[]{mail.getFrom(), mail.getTo(), ((MailMessage) mail).getMessage()});
                } else {
                    logger.log(Level.INFO, "Usual correspondence: from {0} to {1}",
                            new Object[]{mail.getFrom(), mail.getTo()});
                }
            }
            return mail;
        }
    }

    public static class Thief implements MailService {
        private final int minPrice;
        private int Summ;

        public Thief(int minPrice) {
            this.minPrice = minPrice;
            this.Summ = 0;
        }

        @Override
        public Sendable processMail(Sendable mail) {
            if (mail instanceof MailPackage) {
                MailPackage mailPackage = (MailPackage) mail;
                if (mailPackage.getContent().getPrice() >= minPrice) {
                    Summ += mailPackage.getContent().getPrice();
                    Package newPackage = new Package("stones instead of " + mailPackage.getContent().getContent(), 0);
                    return new MailPackage(mail.getFrom(), mail.getTo(), newPackage);
                }
            }
            return mail;
        }

        public int getStolenValue() {
            return Summ;
        }
    }

    public static class Inspector implements MailService {
        @Override
        public Sendable processMail(Sendable mail) {
            if (mail instanceof MailPackage) {
                MailPackage mp = (MailPackage) mail;
                if (mp.getContent().getContent().contains(WEAPONS) || mp.getContent().getContent().contains(BANNED_SUBSTANCE)) {
                    throw new IllegalPackageException();
                }
                if (mp.getContent().getContent().contains("stones") ) {
                    throw new StolenPackageException();
                }
            }
            return mail;
        }
    }

    public static class IllegalPackageException extends RuntimeException {

    }

    public static class StolenPackageException extends RuntimeException {


    }
}


