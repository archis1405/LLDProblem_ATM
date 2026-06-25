package LLD.ATMMachine.ATM_StateDesignPattern.State;

import LLD.ATMMachine.ATM_StateDesignPattern.Enums.ATMStates;
import LLD.ATMMachine.ATM_StateDesignPattern.Model.Card;

public class ReadCardDetailsState implements State{

    @Override
    public int initTransaction() {
        throw new IllegalStateException("Cannot initialize a new transaction when reading card details");
    }

    @Override
    public boolean readCardDetails(Card card) {
        return false;
    }

    @Override
    public int dispenseCash(int transactionId) {
        throw new IllegalStateException("Cannot dispense cash when reading card details");
    }

    @Override
    public void ejectCard() {
        throw new IllegalStateException("Cannot eject card when reading card details");
    }

    @Override
    public boolean readCashWithdrawlDetails(int transactionId, int amount) {
        throw new IllegalStateException("Cannot read cash withdrawl details when reading card details");
    }

    @Override
    public ATMStates getState() {
        return ATMStates.READ_CARD_DETAILS;
    }
}
