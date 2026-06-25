package LLD.ATMMachine.ATM_StateDesignPattern.DTO;

import LLD.ATMMachine.ATM_StateDesignPattern.Enums.ATMStates;

public class UpdateATMStateRequestDTO {

    private final String atmId;
    private final ATMStates newState;

    public UpdateATMStateRequestDTO(String atmId, ATMStates newState) {
        this.atmId = atmId;
        this.newState = newState;
    }

    public String getAtmId() {
        return atmId;
    }

    public ATMStates getNewState() {
        return newState;
    }
}
