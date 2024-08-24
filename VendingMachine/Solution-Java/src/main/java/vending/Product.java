package vending;

public enum Product {
    
    CHIPS(1.25f),
    TRAIL_MIX(2.50f);


    private float price;


    private Product(float price) {
        this.price = price;
    }

    public float getPrice() {
        return this.price;
    }
}
