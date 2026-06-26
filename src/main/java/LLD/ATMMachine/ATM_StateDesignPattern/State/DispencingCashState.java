package LLD.ATMMachine.ATM_StateDesignPattern.State;

import LLD.ATMMachine.ATM_StateDesignPattern.Enums.ATMStates;
import LLD.ATMMachine.ATM_StateDesignPattern.Factory.CardManagerFactory;
import LLD.ATMMachine.ATM_StateDesignPattern.Model.ATM;
import LLD.ATMMachine.ATM_StateDesignPattern.Model.Card;
import LLD.ATMMachine.ATM_StateDesignPattern.services.CardManagerService;
import LLD.ATMMachine.ATM_StateDesignPattern.services.CashDispenseServiceImpl;
import LLD.ATMMachine.ATM_StateDesignPattern.services.CashDispenserService;

public class DispencingCashState implements State{

    private final ATM atm;
    private final CashDispenserService cashDispenserService;
    public DispencingCashState(ATM atm){
        this.atm = atm;
        this.cashDispenserService = new CashDispenseServiceImpl();
    }

    @Override
    public int initTransaction() {
        throw new IllegalStateException("Cannot initiate a new transaction dispensing the cash");
    }

    @Override
    public boolean readCardDetails(Card card, int pin) {
        throw new IllegalStateException("Cannot read card details while dispensing the cash");
    }

    @Override
    public boolean readCashWithdrawlDetails(Card card, int transactionId, double amount) {
        throw new IllegalStateException("Cannot read withdrawl details while dispensing the cash");
    }

    @Override
    public int dispenseCash(Card card , double amount, int transactionId) {
        CardManagerService manager = CardManagerFactory.getCardManager(card.getCardType());

        boolean isTransactionSuccessful = manager.doTransaction(card,amount,transactionId);

        if(isTransactionSuccessful){
            this.cashDispenserService.dispenseCash(this.atm , amount);
            this.atm.changeState(new EjectingCardState(this.atm));
        }
        else{
            System.out.println("Something went wrong coming back to the ready state");
            this.atm.changeState(new ReadyForTransactionState(this.atm));
        }

        return 0;
    }

    @Override
    public void ejectCard() {
        throw new IllegalStateException("Cannot eject a card while dispensing the cash");
    }

    @Override
    public ATMStates getState() {
        return ATMStates.DISPENSE_CASH;
    }

    @Override
    public boolean cancelTransaction(int transactionId) {
        throw new IllegalStateException("Cannot cancel a transaction in the cash dispensing state");
    }
}
