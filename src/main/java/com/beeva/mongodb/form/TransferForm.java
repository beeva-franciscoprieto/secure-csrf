package com.beeva.mongodb.form;

/**
 * Created by franciscoprieto on 25/01/16.
 */
public class TransferForm {

    private String originAccount;
    private String targetAccount;
    private String amount;

    public TransferForm (){

    }

    public String getOriginAccount() {
        return originAccount;
    }

    public void setOriginAccount(String originAccount) {
        this.originAccount = originAccount;
    }
    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public String getTargetAccount() {
        return targetAccount;
    }

    public void setTargetAccount(String targetAccount) {
        this.targetAccount = targetAccount;
    }

    @Override
    public String toString() {
        return "Transfer Data {" +
                "originAccount='" + originAccount + '\'' +
                ", targetAccount='" + targetAccount + '\'' +
                ", amount='" + amount + '\'' +
                '}';
    }
}
