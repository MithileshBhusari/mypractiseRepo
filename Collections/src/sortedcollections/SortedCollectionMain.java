package sortedcollections;

import java.util.Map;

/**
 * @author MithileshB
 * @created 29/06/2020 - 11:12 AM
 * @project mypractiseRepo
 */
public class SortedCollectionMain {
    private static StockList stockList=new StockList();

    public static void main(String[] args) {
        StockItem temp=new StockItem("bread",0.86,100);
        stockList.addStock(temp);

        temp=new StockItem("cake",1.10,7);
        stockList.addStock(temp);

        temp=new StockItem("car",12.50,2);
        stockList.addStock(temp);

        temp=new StockItem("chair",62.0,10);
        stockList.addStock(temp);

        temp=new StockItem("cup",0.50,200);
        stockList.addStock(temp);
        temp=new StockItem("cup",0.45,7);
        stockList.addStock(temp);

        temp=new StockItem("door",72.95,4);
        stockList.addStock(temp);

        temp=new StockItem("juice",2.50,36);
        stockList.addStock(temp);

        temp=new StockItem("phone",96.99,35);
        stockList.addStock(temp);

        temp=new StockItem("towel",2.40,80);
        stockList.addStock(temp);

        temp=new StockItem("vase",8.76,40);
        stockList.addStock(temp);

        System.out.println(stockList);

        for(String s:stockList.items().keySet()){
            System.out.println(s);
        }

        Basket mithileshsBasket=new Basket("Mithilesh");
        sellItem(mithileshsBasket,"car",1);
        System.out.println(mithileshsBasket);

        sellItem(mithileshsBasket,"car",1);
        System.out.println(mithileshsBasket);
        if(sellItem(mithileshsBasket,"car",1)!=1){
            System.out.println("There are no more cars in stock");
        }
        System.out.println(mithileshsBasket);
        sellItem(mithileshsBasket,"soap",5);

        sellItem(mithileshsBasket,"juice",4);
        sellItem(mithileshsBasket,"cup",12);
        sellItem(mithileshsBasket,"bread",1);
        System.out.println(mithileshsBasket);

        System.out.println(stockList);

//        temp=new StockItem("pen",1.12);
//        stockList.items().put(temp.getName(),temp);
        stockList.items().get("car").adjustStock(2000);
        stockList.get("car").adjustStock(-1000);
        System.out.println(stockList);

        for(Map.Entry<String,Double> price:stockList.priceList().entrySet()){
            System.out.println(price.getKey()+" costs "+price.getValue());
        }
    }

    public static int sellItem(Basket basket,String item,int quantity){
        //retrieve the item from the stock list
        StockItem stockItem=stockList.get(item);
        if(stockItem==null){
            System.out.println("We don't sell "+item);
            return 0;
        }
        if(stockList.sellStock(item,quantity)!=0){
            basket.addToBasket(stockItem,quantity);
            return quantity;
        }
        return 0;
    }


}
