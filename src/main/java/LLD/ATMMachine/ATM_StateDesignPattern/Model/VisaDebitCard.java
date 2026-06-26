package LLD.ATMMachine.ATM_StateDesignPattern.Model;

import LLD.ATMMachine.ATM_StateDesignPattern.Enums.CardType;

public class VisaDebitCard  extends Card implements Debit , Visa{

    public VisaDebitCard(long cardNumber, int pin, String name, CardType cardType, String bankName){
        super(cardNumber,pin,name,cardType,bankName);
    }

    @Override
    public void connectToVisaServer() {
        System.out.println("Connecting to the VISA neteork");
    }

    @Override
    public void makePINPayment() {
        System.out.println("Making payment using PIN");
    }
}
