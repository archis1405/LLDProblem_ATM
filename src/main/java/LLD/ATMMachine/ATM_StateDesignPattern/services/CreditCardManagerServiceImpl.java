package LLD.ATMMachine.ATM_StateDesignPattern.services;

import LLD.ATMMachine.ATM_StateDesignPattern.Model.Card;

public class CreditCardManagerServiceImpl implements CardManagerService{
    @Override
    public boolean validateWithdrawl(Card card , int transactionId , double amount) {
        return true;
    }

    @Override
    public boolean doTransaction(Card card , double amount,  int transactionId) {
        return true;
    }

    @Override
    public boolean validateCard(Card card, int pin) {
        return true;
    }
}
