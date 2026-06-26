package LLD.ATMMachine.ATM_StateDesignPattern.services;

import LLD.ATMMachine.ATM_StateDesignPattern.API.BackendAPIInterface;
import LLD.ATMMachine.ATM_StateDesignPattern.API.BackendAPIV1;
import LLD.ATMMachine.ATM_StateDesignPattern.DTO.GetATMAmountRequestDTO;
import LLD.ATMMachine.ATM_StateDesignPattern.Model.ATM;

public class CashDispenseServiceImpl implements CashDispenserService{

    private final BackendAPIInterface backendAPIInterface;

    public CashDispenseServiceImpl(){
        this.backendAPIInterface = new BackendAPIV1();
    }

    @Override
    public void dispenseCash(ATM atm, double amount) {
        int atmAmount = this.backendAPIInterface.getAtmAmount(new GetATMAmountRequestDTO(atm.getAtmId()));

        if(atmAmount < amount){
            throw new RuntimeException("ATM does not enough cash to dispense");
        }

        System.out.println("Dispesing cash"+amount);
    }
}
