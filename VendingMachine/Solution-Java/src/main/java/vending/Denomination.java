package vending;

public enum Denomination {
    QUARTER(0.25f),
    DIME(0.10f),
    NICKLE(0.05f),
    ONE_DOLLAR(1.00f),
    FIVE_DOLLARS(5.00f),
    TEN_DOLLARS(10.00f);
    

    private float value;

    private Denomination(float value) {
        this.value = value;
    }

    public float getValue() {
        return this.value;
    }
}
