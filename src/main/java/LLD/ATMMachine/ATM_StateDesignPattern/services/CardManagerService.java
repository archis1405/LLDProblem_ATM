package LLD.ATMMachine.ATM_StateDesignPattern.services;

import LLD.ATMMachine.ATM_StateDesignPattern.Model.Card;

public interface CardManagerService {
    boolean validateCard(Card card, String pin);

    boolean validateWithdrawl(Card card, double amount);;

    boolean doTransaction(Card card, int transactionId);
}
