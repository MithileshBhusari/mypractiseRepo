package sortedcollections;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 * @author MithileshB
 * @created 29/06/2020 - 10:57 AM
 * @project mypractiseRepo
 */
public class Basket {
    private final String name;
    private final Map<StockItem, Integer> list;

    public Basket(String name) {
        this.name = name;
        this.list = new HashMap<>();
    }

    public int addToBasket(StockItem item, int quantity) {
        if ((item != null) && (quantity > 0)) {
            int inBasket = list.getOrDefault(item, 0);
            System.out.println(item.getName()+" added to basket");
            list.put(item, inBasket + quantity);
            return inBasket;
        }
        System.out.println("returing 0");
        return 0;
    }

    public Map<StockItem, Integer> items() {
        return Collections.unmodifiableMap(list);
    }

    @Override
    public String toString() {
        String s = "\nShopping basket " + name + " contains " + list.size()+ ((list.size()==1) ?"item": " items")+"\n";
        double totalCost = 0.0;
        for (Map.Entry<StockItem, Integer> item : list.entrySet()) {
            s = s + item.getKey() + " , " + item.getValue() + ", purchased\n";
            totalCost += item.getKey().getPrice() * item.getValue();
        }
        return s + " Total cost : " + totalCost;
    }
}
