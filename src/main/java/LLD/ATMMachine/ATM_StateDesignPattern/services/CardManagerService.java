package LLD.ATMMachine.ATM_StateDesignPattern.services;

import LLD.ATMMachine.ATM_StateDesignPattern.Model.Card;

public interface CardManagerService {
    boolean validateCard(Card card, int pin);

    boolean validateWithdrawl(Card card, int transactionId , double amount);;

    boolean doTransaction(Card card, double amount, int transactionId);
}
