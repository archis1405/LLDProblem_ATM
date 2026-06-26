package LLD.ATMMachine.ATM_StateDesignPattern.Model;

import LLD.ATMMachine.ATM_StateDesignPattern.Enums.CardType;

public class MasterCardCreditCard extends Card implements Credit , MasterCard{

    public MasterCardCreditCard(long cardNumber, int pin, String name, CardType cardType, String bankName){
        super(cardNumber,pin,name,cardType,bankName);
    }

    @Override
    public void connectToMasterCardServer() {
        System.out.println("Connecting to Visa Server");
    }

    @Override
    public void makePINPayment() {
        System.out.println("Making PIN Payment using Visa Credit Card");
    }
}
