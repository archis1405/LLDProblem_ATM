package LLD.ATMMachine.ATM_StateDesignPattern.Factory;

import LLD.ATMMachine.ATM_StateDesignPattern.Enums.CardType;
import LLD.ATMMachine.ATM_StateDesignPattern.services.CardManagerService;
import LLD.ATMMachine.ATM_StateDesignPattern.services.CreditCardManagerServiceImpl;
import LLD.ATMMachine.ATM_StateDesignPattern.services.DebitCardManagerServiceImpl;

public class CardManagerFactory {
    public static CardManagerService getCardManager(CardType cardType){
        CardManagerService cardManagerService = null;

        if(cardType.equals(CardType.CREDIT_CARD)){
            cardManagerService = new CreditCardManagerServiceImpl();
        }
        else if(cardType.equals(CardType.DEBIT_CARD)){
            cardManagerService = new DebitCardManagerServiceImpl();
        }
        else{
            throw new IllegalArgumentException("CardType is not supported");
        }

        return cardManagerService;
    }
}
