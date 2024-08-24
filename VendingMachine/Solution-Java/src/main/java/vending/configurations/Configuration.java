package vending.configurations;

import java.util.List;
import java.util.Map;

import vending.Denomination;
import vending.Position;
import vending.Product;

public interface Configuration {

    public Map<Position, List<Product>> initialProducts();

    public Map<Denomination, Integer> initialCapital();

    public List<Denomination> getAllowedDenominations();
    
}
