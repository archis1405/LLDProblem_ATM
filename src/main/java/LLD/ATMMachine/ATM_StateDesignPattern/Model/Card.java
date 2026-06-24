package LLD.ATMMachine.ATM_StateDesignPattern.Model;

public class Card {
    private final long cardNumber;

    private final int PIN;

    private final String name;

    private final String cardType;

    private final String bankName;

    Card(long cardNumber, int PIN, String name, String cardType, String bankName){
        this.cardNumber = cardNumber;
        this.PIN = PIN;
        this.name = name;
        this.cardType = cardType;
        this.bankName = bankName;
    }

    public long getCardNumber() {
        return cardNumber;
    }

    public int getPIN() {
        return PIN;
    }

    public String getName() {
        return name;
    }

    public String getCardType() {
        return cardType;
    }

    public String getBankName() {
        return bankName;
    }

    public String toString(){
        return "Card Number :: "+cardNumber+" , Card Type :: "+cardType+" , Bank Name :: "+bankName;
    }
}
