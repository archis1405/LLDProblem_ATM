package LLD.ATMMachine.ATM_StateDesignPattern.services;

import LLD.ATMMachine.ATM_StateDesignPattern.Model.Card;

public class DebitCardManagerServiceImpl implements CardManagerService{
    @Override
    public boolean validateCard(Card card, String pin) {
        /*
            the card validation will be ideally done by our backend
            so, here we will be having a API call for the card validation
         */
        return false;
    }

    @Override
    public boolean doTransaction(Card card, int transactionId) {
        return false;
    }

    @Override
    public boolean validateWithdrawl(Card card, double amount) {
        return false;
    }
}
