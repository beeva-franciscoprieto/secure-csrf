package com.beeva.mongodb.form;

import java.io.Serializable;

public class AccountForm implements Serializable {

	private static final long serialVersionUID = -6063993380423834607L;
    //@AccountNumber
	private String accountNumber;

    private boolean favorite;

	public AccountForm() {
	}

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public boolean isFavorite() {
        return favorite;
    }

    public void setFavorite(boolean favorite) {
        this.favorite = favorite;
    }
}
