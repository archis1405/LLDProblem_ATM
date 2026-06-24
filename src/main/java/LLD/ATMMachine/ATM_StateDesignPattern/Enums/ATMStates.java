package LLD.ATMMachine.ATM_StateDesignPattern.Enums;

public enum ATMStates {
    READY_FOR_TRANSACTION,
    READ_CARD_DETAILS,
    DISPENSE_CASH,
    EJECTING_CARD,
    READING_CASH_WITHDRAWAL_DETAILS
}

/*
    NOTE : CANCELLATION is not a stare it is an ation that will take us back to the ready state
 */
