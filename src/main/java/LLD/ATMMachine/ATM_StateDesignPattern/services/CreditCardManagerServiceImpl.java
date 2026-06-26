package LLD.ATMMachine.ATM_StateDesignPattern.services;

import LLD.ATMMachine.ATM_StateDesignPattern.Model.Card;

public class CreditCardManagerServiceImpl implements CardManagerService{
    @Override
    public boolean validateWithdrawl(Card card, double amount) {
        return false;
    }

    @Override
    public boolean doTransaction(Card card, int transactionId) {
        return false;
    }

    @Override
    public boolean validateCard(Card card, String pin) {
        return false;
    }
}
