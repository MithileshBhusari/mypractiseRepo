package sortedcollections;

import java.util.*;

/**
 * @author MithileshB
 * @created 28/06/2020 - 8:13 PM
 * @project mypractiseRepo
 */
public class StockList {

    private final Map<String,StockItem> list;

    public StockList(){
        this.list=new LinkedHashMap<>   ();
    }

    public int addStock(StockItem item){
        if(item!=null){
            //check if already have quantity of this item
            StockItem intStock=list.getOrDefault(item.getName(),item);
        //if there are already stock in this item,adjust the stockQuantity
            if(intStock!=item){
                item.adjustStock(intStock.availableQuantity());
            }
            list.put(item.getName(),item);
            return item.availableQuantity();
        }
        return 0;
    }

    public int sellStock(String item,int quantity){
        StockItem inStock=list.get(item);
        if ((inStock != null) && (quantity > 0)){
            return inStock.finalizeStock(quantity);
        }
        return 0;
//        StockItem inStock=list.getOrDefault(item,null);
//        if((inStock!=null) && (inStock.availableQuantity()>=quantity) && (quantity>0)){
//            inStock.adjustStock(-quantity);
//            return quantity;
//        }
//        return 0;
    }

    public int reserveStock(String item,int quantity){
        StockItem inStock=list.get(item);
        if((inStock!=null) && (quantity>0)){
            return inStock.reserveStock(quantity);
        }
        return 0;
    }

    public int unreserveStock(String item,int quantity){
        StockItem inStock=list.get(item);
        if((inStock!=null) && (quantity>0)){
            return inStock.unreserveStock(quantity);
        }
        return 0;
    }

    public StockItem get(String key){
        return list.get(key);
    }
    public Map<String,StockItem> items(){
        return Collections.unmodifiableMap(list);
    }

    public Map<String,Double> priceList(){
        Map<String,Double> prices=new LinkedHashMap<>();
        for(Map.Entry<String,StockItem> item:list.entrySet()){
            prices.put(item.getKey(),item.getValue().getPrice());
        }
        return Collections.unmodifiableMap(prices);
    }
    @Override
    public String toString() {
        String s="\nStockList\n" ;
        double totalCost=0.0;

        for(Map.Entry<String,StockItem> item:list.entrySet()){
            StockItem stockItem=item.getValue();
            double itemValue=stockItem.getPrice()*stockItem.availableQuantity();

            s=s+stockItem+", There are  "+stockItem.availableQuantity()+" in stock. Value of items: ";
            s=s+String.format("%.2f",itemValue)+"\n";
            totalCost+=itemValue;
        }

        return s+"Total stock value "+totalCost;
    }
}

