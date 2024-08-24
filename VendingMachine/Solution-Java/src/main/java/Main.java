
import vending.*;
import vending.configurations.*;

/**
 * 
 * This is one way you might "run" your code. This would do the vending machine on a loop and request user input
 */
public class Main {
    public static void main(String[] args) {

        // Configure Vending Machine
        Configuration config = ExampleConfiguration.get();
        VendingMachine machine = new VendingMachine(config.initialProducts(), config.initialCapital(), config.getAllowedDenominations());

        while (true) {
            // TODO: Implement user input loop
        }
    }

}
