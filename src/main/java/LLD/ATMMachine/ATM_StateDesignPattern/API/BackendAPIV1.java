package LLD.ATMMachine.ATM_StateDesignPattern.API;

import LLD.ATMMachine.ATM_StateDesignPattern.DTO.CreateTransactionRequestDTO;
import LLD.ATMMachine.ATM_StateDesignPattern.DTO.GetATMAmountRequestDTO;
import LLD.ATMMachine.ATM_StateDesignPattern.DTO.UpdateATMStateRequestDTO;

public class BackendAPIV1 implements BackendAPIInterface {
    /*
        this class should be only responsible for connecting the backend service and giving the response back
     */

    public int createTransaction(CreateTransactionRequestDTO createTransactionDTO){
        /*
            steps for the tracnsaction id generation
         */

        /*Validation -> just mimicing the validations

        if(createTransactionDTO.getAtmId() == null || createTransactionDTO.getAtmId().isEmpty()){
            throw new IllegalArgumentException("ATM ID cannot be null or empty");
        }
        */

        //Connect to the backend service and generate a transaction id
        //For the sake of this example, we will just return a random transaction id
        int txnId = (int)(Math.random() * 100000);

        return  txnId;
    }

    @Override
    public boolean updateState(UpdateATMStateRequestDTO updateATMStateDTO) {
        /*
            steps for the state update -> assuming the backend service sends a success response
         */
        return true;
    }

    @Override
    public int getAtmAmount(GetATMAmountRequestDTO atmId) {
        return 100000;// dummy call
    }
}
