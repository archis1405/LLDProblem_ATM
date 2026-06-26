package LLD.ATMMachine.ATM_StateDesignPattern.Model;

import LLD.ATMMachine.ATM_StateDesignPattern.API.BackendAPIInterface;
import LLD.ATMMachine.ATM_StateDesignPattern.API.BackendAPIV1;
import LLD.ATMMachine.ATM_StateDesignPattern.DTO.UpdateATMStateRequestDTO;
import LLD.ATMMachine.ATM_StateDesignPattern.State.ReadyForTransactionState;
import LLD.ATMMachine.ATM_StateDesignPattern.State.State;

public class ATM {
    private final String atmId;
    private State currentState;
    private final BackendAPIInterface backendAPIV1;

    //It is taking atmId as a parameter because we can have multiple ATMs in the system and each ATM will have a unique id
    public ATM(String atmId) {
        this.atmId = atmId;
        this.backendAPIV1 = new BackendAPIV1();
        this.currentState = new ReadyForTransactionState(this);
    }

    public String getAtmId() {
        return atmId;
    }

    /*
        The State is needed to be stored in the ATM class because when the ATM restarts
        we donot want the ATM to start from the initial state, because that violates the principle of single state at a tme

        the previous transsation is in lets say card reading state, and new transaction is initiated,
        the ATM should be in the card reading state and not in the ready for transaction state

        so we need to store the data both in the client and the server thats why we need this API Call
     */

    // The ATM class is responsible for changing the state of the ATM Machine not any other class

    public void changeState(State newState) {
        this.currentState = newState;
        // call the server to persist the state on the server/DB also

        this.backendAPIV1.updateState(new UpdateATMStateRequestDTO(this.atmId , newState.getState()));
    }

}
