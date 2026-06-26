package LLD.ATMMachine.ATM_StateDesignPattern.State;

import LLD.ATMMachine.ATM_StateDesignPattern.Enums.ATMStates;
import LLD.ATMMachine.ATM_StateDesignPattern.Factory.CardManagerFactory;
import LLD.ATMMachine.ATM_StateDesignPattern.Model.ATM;
import LLD.ATMMachine.ATM_StateDesignPattern.Model.Card;
import LLD.ATMMachine.ATM_StateDesignPattern.services.CardManagerService;

public class ReadingCashWithdrawlDetailsState implements State{

    private final ATM atm;

    public ReadingCashWithdrawlDetailsState(ATM atm){
        this.atm = atm;
    }

    @Override
    public int initTransaction() {
        throw new IllegalStateException("Cannot initiate a transaction while reading withdrawl details");
    }

    @Override
    public boolean readCardDetails(Card card, int pin) {
        throw new IllegalStateException("Cannot read card details while reading withdrawl details");
    }

    @Override
    public boolean readCashWithdrawlDetails(Card card , int transactionId, double amount) {

        CardManagerService manager = CardManagerFactory.getCardManager(card.getCardType());

        boolean isWithdrawlValid = manager.validateWithdrawl(card,transactionId,amount);

        if(isWithdrawlValid){
            this.atm.changeState(new DispencingCashState(this.atm));
        }
        else{
            this.atm.changeState(new EjectingCardState(this.atm));
        }

        return isWithdrawlValid;
    }

    @Override
    public int dispenseCash(Card card , double amount , int transactionId) {
        throw new IllegalStateException("Cannot dispense cash while reading withdrawl details");
    }

    @Override
    public void ejectCard() {
        throw new IllegalStateException("Cannot eject card while reading withdrawl details");
    }

    @Override
    public ATMStates getState() {
        return ATMStates.READING_CASH_WITHDRAWAL_DETAILS;
    }

    @Override
    public boolean cancelTransaction(int transactionId) {
        try{
            this.atm.changeState(new ReadyForTransactionState(this.atm));
            return true;
        }
        catch(Exception e){
            throw new IllegalStateException("Cannot cancel a transaction");
        }
    }
}
