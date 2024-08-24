package vending;
import java.util.*;
import java.util.stream.Collectors;

import exception.VendingException;

public class VendingMachine {

    /**
     * Current inventory (Count of each product type)
     */
    private Map<Position, List<Product>> inventory;


    /**
     * Current available capital
     */
    private Map<Denomination, Integer> capital;

    /**
     * Current money for the transaction
     */
    private Map<Denomination, Integer> payment;


    /*************************
     * Machine Configuration *
     *************************/

    private final List<Denomination> allowedDenominations;

    /*****************************
     *  Hardware Services (Fake) *
     ****************************/

    private final VendingIntegration vending = new MockVendingIntegration();


    public VendingMachine(
            Map<Position, List<Product>> initialInventory, 
            Map<Denomination, Integer> initialCapital,

            List<Denomination> allowedDenominations
        ) {
        this.inventory = initialInventory;
        this.capital = initialCapital;

        this.allowedDenominations = allowedDenominations;

        this.payment = new HashMap<>();
    }

    /*************************
     * Mutations/Operations
     ************************/

    public void vend(Position position) throws VendingException {
        System.out.println("Attempting to vend from position " + position.name());
        if (this.canVend(position)) {
            Product toVend = this.inventory.get(position).get(0);
            System.out.println("Vending 1 " + toVend.name());
            this.vending.vend(position);

            this.transferPayment(toVend.getPrice());
            this.reduceInventory(position);
            
            System.out.println("Successfully vended!");
        } else {
            System.out.println("Cannot vend from position " + position.name());

        }
    }

    public float addPayment(Denomination d) {
        System.out.println("Adding " + d.name() + " to payment");
        if (!this.payment.containsKey(d)) {
            this.payment.put(d, 0);
        }
        this.payment.put(d, this.payment.get(d) + 1);
        float newTotal = getCapital(this.payment);

        System.out.println("New payment total: $" + newTotal);

        return newTotal;
    }

    private boolean transferPayment(float price) {
        System.out.println("Transferring payment $" + price + " to total capital ($" + getCapital(this.capital) +  ")");
        // TODO: Algorithm to figure out how to reduce the price via denominations the machine has
        return true;
    }

    private void reduceInventory(Position p) {
        System.out.println("Reducing Inventory in Position " + p.name());
        List<Product> productsAtPosition = this.inventory.get(p);
        this.inventory.put(p, this.inventory.get(p).subList(1, productsAtPosition.size()));
        System.out.println("New Inventory at " + p + ": " + inventoryAtPosition(p).stream().map(i -> i.name()).collect(Collectors.joining(",")));
    }


    /***********
     * Queries *
     **********/

    public List<Denomination> getAllowedDenominations() {
        return this.allowedDenominations;
    }
    
    public boolean isDenominationAllowed(Denomination d) {
        return this.allowedDenominations.contains(d);
    }

    public boolean canVend(Position p) {
        System.out.println("Checking if machine can vend " + p.name());
        boolean canVend = this.inventory.containsKey(p)
            && this.inventory.get(p).size() > 0 
            && this.inventory.get(p).get(0).getPrice() <= getCapital(this.payment);
        System.out.println(canVend ? "Vending allowed!" : "Cannot vend from this position!");
        return canVend;
    }

    public List<Product> inventoryAtPosition(Position p) {
        return this.inventory.containsKey(p) ? this.inventory.get(p) : Collections.emptyList();
    }

    public float getCurrentPayment() {
        System.out.println("Checking current payment...");
        float p = this.getCapital(this.payment);
        System.out.println("Currently paid: [$" + p + "]");
        return p;
    }

    public float getTotalCapital() {
        System.out.println("Checking current capital...");
        float c = this.getCapital(this.capital);
        System.out.println("Current available capital: [$" + c + "]");
        return c;
    }

    public float getCapital(Map<Denomination, Integer> capital) {
        float total = 0;
        for (Map.Entry<Denomination, Integer> e : capital.entrySet()) {
            total += (e.getValue() * e.getKey().getValue());
        }

        return total;
    }
}
