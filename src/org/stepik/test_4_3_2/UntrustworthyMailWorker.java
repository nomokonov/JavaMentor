package org.stepik.test_4_3_2;

public class UntrustworthyMailWorker implements  MailService {
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
    public RealMailService getRealMailService(){
        return realMailService;
    }

}
