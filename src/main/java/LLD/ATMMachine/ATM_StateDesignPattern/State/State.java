package LLD.ATMMachine.ATM_StateDesignPattern.State;

import LLD.ATMMachine.ATM_StateDesignPattern.Enums.ATMStates;
import LLD.ATMMachine.ATM_StateDesignPattern.Model.Card;


public interface State {
    /*
        The State interface will tell us that all the states on out ATM machine
        needs to do something on this particular actions , so here were are
        defining the actions that all the states need to implement
     */

    int initTransaction(); // start of the transaction

    boolean readCardDetails(Card card , int pin); // read the card details

    int dispenseCash(Card card , double amount , int transactionId); // dispense the cash

    void ejectCard(); // eject the card

    boolean readCashWithdrawlDetails(Card card , int transactionId , double amount); // read the cash withdrawl details

     ATMStates getState(); // get the current state of the ATM

    boolean cancelTransaction(int transactionId);
}
