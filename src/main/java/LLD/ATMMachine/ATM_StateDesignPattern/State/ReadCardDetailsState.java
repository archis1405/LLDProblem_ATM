package LLD.ATMMachine.ATM_StateDesignPattern.State;

import LLD.ATMMachine.ATM_StateDesignPattern.Enums.ATMStates;
import LLD.ATMMachine.ATM_StateDesignPattern.Enums.CardType;
import LLD.ATMMachine.ATM_StateDesignPattern.Model.Card;

public class ReadCardDetailsState implements State{

    @Override
    public int initTransaction() {
        throw new IllegalStateException("Cannot initialize a new transaction when reading card details");
    }

    @Override
    public boolean readCardDetails(Card card) {
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
         */
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
