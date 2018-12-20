package org.stepik.test_4_3_2;

public class Theif implements  MailService {
    private  final int minPrice;
    private int Summ;
    public Theif(int minPrice ) {
        this.minPrice = minPrice;
        this.Summ = 0;
    }

    @Override
    public Sendable processMail(Sendable mail) {
        if ( mail instanceof MailPackage){
            MailPackage mailPackage = (MailPackage) mail;
            Package mPackage = mailPackage.getContent();
            if ( mPackage.getPrice() > minPrice) {
                Summ += mPackage.getPrice();
                Package newPackage = new Package("stones instead of " + ((Package) mail).getContent(),0);
                return new MailPackage(mail.getFrom(),mail.getTo(),Package);
            }
        }
        return mail;
    }

    public int getStolenValue(){
        return Summ;
    }
}
