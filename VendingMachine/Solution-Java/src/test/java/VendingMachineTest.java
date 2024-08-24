import org.junit.Test;

import vending.Denomination;
import vending.Position;
import vending.Product;
import vending.VendingMachine;

import static org.junit.Assert.*;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;


/**
 * A test can be a great way to run your code and ensure you are doing things right
 */
public class VendingMachineTest {
    
    @Test
    public void setupMachine() throws Exception {

        // Arrange
        Map<Position, List<Product>> layout = new HashMap<>();
        layout.put(Position.A1, Stream.generate(() -> Product.CHIPS).limit(10).collect(Collectors.toList()));
        layout.put(Position.A2, Stream.generate(() -> Product.TRAIL_MIX).limit(10).collect(Collectors.toList()));

        Map<Denomination, Integer> startingMoney = new HashMap<>();
        startingMoney.put(Denomination.NICKLE, 100);
        startingMoney.put(Denomination.DIME, 100);
        startingMoney.put(Denomination.QUARTER, 100);
        startingMoney.put(Denomination.ONE_DOLLAR, 50);
        startingMoney.put(Denomination.FIVE_DOLLARS, 5);

        List<Denomination> allowedDenominations =  Arrays.asList(
            Denomination.DIME, Denomination.QUARTER, Denomination.NICKLE,
            Denomination.ONE_DOLLAR, Denomination.FIVE_DOLLARS
        );

        VendingMachine v = new VendingMachine(layout, startingMoney, allowedDenominations);

        // Assert

        // Check starting capital
        assertEquals("Starting Total should be $115", 115.0f, v.getTotalCapital(), 0); 
        assertEquals("Starting Payment should be 0", 0.00f, v.getCurrentPayment(), 0);

        // Check that canVend correctly returns for positions that exist and don't exist
        assertFalse("Shouldn't be able to vend from Position A1 (Not enough money)", v.canVend(Position.A1));
        assertFalse("Shouldn't be able to vend from Position A2 (Not enough money)", v.canVend(Position.A2));
        assertFalse("Shouldn't be able to vend form Position A3 (Machine not configured)", v.canVend(Position.A3));

        v.addPayment(Denomination.FIVE_DOLLARS); // Add Payment to allow vending

        assertEquals("Current Payment should be $5 after a 5 dollar bill", 5.00f, v.getCurrentPayment(), 0);

        assertTrue("Should be able to vend from Position A1 (After money added)", v.canVend(Position.A1));
        assertTrue("Should be able to vend from Position A2 (After money added)", v.canVend(Position.A2));


        v.vend(Position.A1);
    }
}
