package LLD.ATMMachine.ATM_StateDesignPattern.Model;

import LLD.ATMMachine.ATM_StateDesignPattern.Enums.CardType;

public class VisaCreditCard extends Card implements Visa,Credit{

    public VisaCreditCard(long cardNumber, int pin, String name, CardType cardType, String bankName){
        super(cardNumber,pin,name,cardType,bankName);
    }

    @Override
    public void connectToVisaServer() {
        System.out.println("Connecting to Visa Server");
    }

    @Override
    public void makePINPayment() {
        System.out.println("Making PIN Payment using Visa Credit Card");
    }
}
