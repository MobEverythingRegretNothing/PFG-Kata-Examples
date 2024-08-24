package vending;

import exception.VendingException;

public class MockVendingIntegration implements VendingIntegration {

    /**
     * Pretending this is some hardware integration
     */
    public void vend(Position position) throws VendingException {
        System.out.println("Vending 1 item from position " + position.name());
    }


    
}
