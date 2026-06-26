package LLD.ATMMachine.ATM_StateDesignPattern.State;

import LLD.ATMMachine.ATM_StateDesignPattern.Enums.ATMStates;
import LLD.ATMMachine.ATM_StateDesignPattern.Model.ATM;
import LLD.ATMMachine.ATM_StateDesignPattern.Model.Card;

public class EjectingCardState implements State{

    private final ATM atm;

    public EjectingCardState(ATM atm){
        this.atm = atm;
    }

    @Override
    public int initTransaction() {
        throw new IllegalStateException("Cannot imnitiate a new transaction as card is getting ejected");
    }

    @Override
    public boolean readCardDetails(Card card, int pin) {
        throw new IllegalStateException("Cannot read card details as card is getting ejected");
    }

    @Override
    public boolean readCashWithdrawlDetails(Card card, int transactionId, double amount) {
        throw new IllegalStateException("Cannot read withdrawl details as card is getting ejected");
    }

    @Override
    public int dispenseCash(Card card, double amount, int transactionId) {
        throw new IllegalStateException("Cannot dispense cash as card is getting ejected");
    }

    @Override
    public void ejectCard() {
        System.out.println("Card ejected please take the card");

        this.atm.changeState(new ReadyForTransactionState(this.atm));

    }
;
    @Override
    public ATMStates getState() {
        return ATMStates.EJECTING_CARD;
    }

    @Override
    public boolean cancelTransaction(int transactionId) {
        throw new IllegalStateException("Cannot cancel transaction as card is getting ejected");
    }
}
