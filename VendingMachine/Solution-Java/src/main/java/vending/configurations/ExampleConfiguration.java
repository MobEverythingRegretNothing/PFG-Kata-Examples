package vending.configurations;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import vending.Denomination;
import vending.Position;
import vending.Product;

public class ExampleConfiguration implements Configuration {

    public static Configuration get() {
        return new ExampleConfiguration();
    }

    @Override
    public Map<Position, List<Product>> initialProducts() {
        Map<Position, List<Product>> layout = new HashMap<>();
        layout.put(Position.A1, Stream.generate(() -> Product.CHIPS).limit(10).collect(Collectors.toList()));
        layout.put(Position.A2, Stream.generate(() -> Product.TRAIL_MIX).limit(10).collect(Collectors.toList()));
        return layout;
    }

    @Override
    public Map<Denomination, Integer> initialCapital() {
        Map<Denomination, Integer> startingMoney = new HashMap<>();
        startingMoney.put(Denomination.NICKLE, 100);
        startingMoney.put(Denomination.DIME, 100);
        startingMoney.put(Denomination.QUARTER, 100);
        startingMoney.put(Denomination.ONE_DOLLAR, 50);
        startingMoney.put(Denomination.FIVE_DOLLARS, 5);
        return startingMoney;
    }

    @Override
    public List<Denomination> getAllowedDenominations() {
        return Arrays.asList(
            Denomination.DIME, Denomination.QUARTER, Denomination.NICKLE,
            Denomination.ONE_DOLLAR, Denomination.FIVE_DOLLARS
        );
    }
    
    
}
