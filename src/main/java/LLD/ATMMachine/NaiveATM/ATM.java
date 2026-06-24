package LLD.ATMMachine.NaiveATM;

public class ATM {

    private String atmId;
    private ATMState state;

    public ATM(String id){
        this.atmId = id;
        this.state = ATMState.IDLE;
    }

    // Start of a transaction, if the ATM is not in IDLE state, throw an exception
    public int StartTransaction(){
        if(state != ATMState.IDLE){
            throw new IllegalStateException("ATM is currently occupied");
        }

        else{
            state = ATMState.TRANSACTION_IN_PROGRESS;
            int transactionId = generateTransactionId();

            System.out.println("Transaction Started !!");
            System.out.println("Transaction Id :: "+transactionId + " on ATM :: "+atmId);

            return transactionId;

        }
    }

    public void cancelTransaction(int transactionId){
        if(state == ATMState.IDLE){
            throw new IllegalStateException("No transaction in progress");
        }
        else if(state == ATMState.DISPENSING_CASH){
            throw new IllegalStateException("Transaction is in progress, cannot cancel");
        }
        else{
            state = ATMState.IDLE;
            System.out.println("Transaction Cancelled !!");
            System.out.println("Transaction Id :: "+transactionId + " on ATM :: "+atmId);
        }
    }

    public int generateTransactionId(){
        return (int)(Math.random() * 100000);
    }

    public boolean readCardDetails(String cardType , String cardNumber, String cardPin){
        if(state != ATMState.TRANSACTION_IN_PROGRESS){
            throw new IllegalStateException("Transaction not in progress");
        }
        else{
            state = ATMState.CARD_INSERTED;

            boolean validCard = validateCard(cardType, cardNumber, cardPin);

            if(!validCard){
                System.out.println("Invalid Card Details !!");
                state = ATMState.IDLE;
                return validCard;
            }

            else{
                System.out.println("Card Details Read !!");
                System.out.println("Card Type :: "+cardType + " Card Number :: "+cardNumber + " Card Pin :: "+cardPin);
                return validCard;
            }

        }
    }

    public boolean validateCard(String cardType , String cardNumber, String cardPin){
        // For simplicity, we will assume that the card is valid if the card number is 16 digits and the pin is 4 digits
        if(cardNumber.length() == 16 && cardPin.length() == 4 && (cardType.equals("VISA") || cardType.equals("MASTERCARD"))){
            return true;
        }
        else{
            return false;
        }
    }

    public boolean enterAmount(double amount){
        if(state != ATMState.CARD_INSERTED){
            throw new IllegalStateException("Card not inserted");
        }
        else{
            state = ATMState.AMOUNT_ENTERED;
            return checkBalance(amount);
        }
    }

    public boolean checkBalance(double amount){
        // For simplicity, we will assume that the balance is always sufficient and update the amount in account
        System.out.println("Amount Entered :: "+amount);
        return true;
    }

    public void dispenseCash(double amount){
        if(state != ATMState.AMOUNT_ENTERED){
            throw new IllegalStateException("Amount not entered");
        }
        else{
            state = ATMState.DISPENSING_CASH;
            System.out.println("Dispensing Cash :: "+amount);
            state = ATMState.IDLE;
        }
    }
}
