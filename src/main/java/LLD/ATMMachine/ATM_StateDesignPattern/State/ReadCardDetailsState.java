package LLD.ATMMachine.ATM_StateDesignPattern.State;

import LLD.ATMMachine.ATM_StateDesignPattern.Enums.ATMStates;
import LLD.ATMMachine.ATM_StateDesignPattern.Enums.CardType;
import LLD.ATMMachine.ATM_StateDesignPattern.Factory.CardManagerFactory;
import LLD.ATMMachine.ATM_StateDesignPattern.Model.ATM;
import LLD.ATMMachine.ATM_StateDesignPattern.Model.Card;
import LLD.ATMMachine.ATM_StateDesignPattern.services.CardManagerService;


public class ReadCardDetailsState implements State{

    private final ATM atm;

    public ReadCardDetailsState(ATM atm){
        this.atm = atm;
    }

    @Override
    public int initTransaction() {
        throw new IllegalStateException("Cannot initialize a new transaction when reading card details");
    }

    @Override
    public boolean readCardDetails(Card card , int pin) {
        /*
            Here we can implement the logic to read the card details and validate the card
            and then return true if the card is valid and false if the card is invalid

            if(card.getCardType().equals(CardType.DEBIT_CARD)){
                // if card is a debit card then create a new DebitCardManager Service object
            }
            else if(card.getCardType().equals(CardType.CREDIT_CARD)){
                // if card is a debit card then create a new DebitCardManager Service object
            }

            This above implementation violates OCP

            The type of the card manager is going to be decided at the runtime
            if more card managers come up there will be more if else statements coming up
         */

        CardManagerService manager = CardManagerFactory.getCardManager(card.getCardType());

        boolean iscardValid = manager.validateCard(card,pin);

        if(iscardValid){
            this.atm.changeState(new ReadingCashWithdrawlDetailsState(this.atm));
        }
        else{
            //move to the initial ready for transaction state
            this.atm.changeState(new ReadyForTransactionState(this.atm));
        }

        return iscardValid;
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
    public boolean readCashWithdrawlDetails(Card card , int transactionId, double amount) {
        throw new IllegalStateException("Cannot read cash withdrawl details when reading card details");
    }

    @Override
    public ATMStates getState() {
        return ATMStates.READ_CARD_DETAILS;
    }

    @Override
    public boolean cancelTransaction(int transactionId) {
        try{
            this.atm.changeState(new ReadyForTransactionState(this.atm));
            return true;
        }
        catch(Exception e) {
            throw new IllegalStateException("Cannot cancel a transaction");
        }
    }
}
