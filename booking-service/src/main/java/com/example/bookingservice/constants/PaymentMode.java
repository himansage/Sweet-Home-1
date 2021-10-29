package com.example.bookingservice.constants;

/**
 * Enum for PaymentMode constants
 * Values:
 * CARD,UPI
 */
public enum PaymentMode {
    CARD("CARD"),
    UPI("UPI");

    private String value;
    PaymentMode(String value) {
        this.value = value;
    }
    public String value() {
        return this.value;
    }

    public static boolean contains(String key){
        for(PaymentMode paymentMode : PaymentMode.values()) {
            if (paymentMode.value().equals(key)) {
                return true;
            }
        }
        return false;
    }
}
