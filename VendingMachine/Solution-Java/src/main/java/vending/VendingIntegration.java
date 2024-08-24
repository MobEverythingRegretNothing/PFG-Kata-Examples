package vending;

import exception.VendingException;

public interface VendingIntegration {

    void vend(Position position) throws VendingException;

}