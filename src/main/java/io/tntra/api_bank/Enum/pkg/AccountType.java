package io.tntra.api_bank.Enum.pkg;

public enum AccountType {
    SAVINGS("SAVINGS"),
    CURRENT("CURRENT"),
    FD("FD");

    public String value;

    AccountType(String value) {
        this.value = value;
    }
}
