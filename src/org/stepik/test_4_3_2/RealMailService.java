package org.stepik.test_4_3_2;
/*
Класс, в котором скрыта логика настоящей почты
*/
public  class RealMailService implements MailService {

    @Override
    public Sendable processMail(Sendable mail) {
        // Здесь описан код настоящей системы отправки почты.
        return mail;
    }
}