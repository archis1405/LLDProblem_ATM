package LLD.ATMMachine.ATM_StateDesignPattern.services;

import LLD.ATMMachine.ATM_StateDesignPattern.Model.ATM;

public interface CashDispenserService {
    //This is the backend service that will validate if the cast is available for cash withdrawl
    // we need to check both the amount available in the atm and how much the user wants to withdraw
    void dispenseCash(ATM atm, double amount);
}
