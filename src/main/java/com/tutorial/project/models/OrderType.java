package com.tutorial.project.models;

public enum OrderType {
    PURCHASE("Purchase Order"),
    SALE("Sales Order"),
    RETURN("Return Order");

    private final String displayName;

    OrderType(String displayName) {
        this.displayName = displayName;
    }

    public String getDisplayName() {
        return displayName;
    }
}
