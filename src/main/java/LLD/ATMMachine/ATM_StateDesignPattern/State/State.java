package LLD.ATMMachine.ATM_StateDesignPattern.State;

import LLD.ATMMachine.ATM_StateDesignPattern.Model.Card;
import LLD.ATMMachine.NaiveATM.ATMState;

public interface State {
    /*
        The State interface will tell us that all the states on out ATM machine
        needs to do something on this particular actions , so here were are
        defining the actions that all the states need to implement
     */

    int initTransaction(); // start of the transaction

    boolean readCardDetails(Card card); // read the card details

    int dispenseCash(int transactionId); // dispense the cash

    void ejectCard(); // eject the card

    boolean readCashWithdrawlDetails(int transactionId , int amount); // read the cash withdrawl details

    ATMState getState(); // get the current state of the ATM
}
