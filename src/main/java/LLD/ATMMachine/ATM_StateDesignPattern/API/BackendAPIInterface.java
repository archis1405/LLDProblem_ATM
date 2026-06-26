package LLD.ATMMachine.ATM_StateDesignPattern.API;

import LLD.ATMMachine.ATM_StateDesignPattern.DTO.CreateTransactionRequestDTO;
import LLD.ATMMachine.ATM_StateDesignPattern.DTO.GetATMAmountRequestDTO;
import LLD.ATMMachine.ATM_StateDesignPattern.DTO.UpdateATMStateRequestDTO;

public interface BackendAPIInterface {
    int createTransaction(CreateTransactionRequestDTO createTransactionDTO);

    boolean updateState(UpdateATMStateRequestDTO updateATMStateDTO);

    int getAtmAmount(GetATMAmountRequestDTO getATMAmountRequestDTO);
}
