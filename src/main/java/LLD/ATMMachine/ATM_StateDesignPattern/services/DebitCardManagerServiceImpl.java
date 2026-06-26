package LLD.ATMMachine.ATM_StateDesignPattern.services;

import LLD.ATMMachine.ATM_StateDesignPattern.Model.Card;

public class DebitCardManagerServiceImpl implements CardManagerService{
    @Override
    public boolean validateCard(Card card, int pin) {
        /*
            the card validation will be ideally done by our backend
            so, here we will be having a API call for the card validation
         */
        return true;
    }

    @Override
    public boolean doTransaction(Card card, double amount, int transactionId) {
        return true;
    }

    @Override
    public boolean validateWithdrawl(Card card , int transactionId, double amount) {
        return true;
    }
}
