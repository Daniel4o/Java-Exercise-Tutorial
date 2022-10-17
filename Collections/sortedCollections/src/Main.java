import java.util.Iterator;

public class Main {
    private static StockList stockList = new StockList();

    public Main() {
    }

    public static void main(String[] args) {
        StockItem temp = new StockItem("bread", 0.86, 100);
        stockList.addStock(temp);
        temp = new StockItem("cake", 1.1, 7);
        stockList.addStock(temp);
        temp = new StockItem("car", 12.5, 2);
        stockList.addStock(temp);
        temp = new StockItem("chair", 62.0, 10);
        stockList.addStock(temp);
        temp = new StockItem("cup", 0.5, 200);
        stockList.addStock(temp);
        temp = new StockItem("door", 72.95, 4);
        stockList.addStock(temp);
        temp = new StockItem("juice", 2.5, 36);
        stockList.addStock(temp);
        temp = new StockItem("phone", 96.99, 35);
        stockList.addStock(temp);
        temp = new StockItem("towel", 2.4, 80);
        stockList.addStock(temp);
        temp = new StockItem("vase", 8.76, 40);
        stockList.addStock(temp);
        System.out.println(stockList);
        Iterator var2 = stockList.Items().keySet().iterator();

        while(var2.hasNext()) {
            String s = (String)var2.next();
            System.out.println(s);
        }
        Basket usersBasket = new Basket("Tim");
        sellItem(usersBasket, "car", 1);
        System.out.println(usersBasket);
        sellItem(usersBasket, "car", 1);
        System.out.println(usersBasket);
        if (sellItem(usersBasket, "car", 1) != 1) {
            System.out.println("There are no more cars in stock");
        }

        sellItem(usersBasket, "spanner", 5);
        System.out.println(usersBasket);
        sellItem(usersBasket, "juice", 4);
        sellItem(usersBasket, "cup", 12);
        sellItem(usersBasket, "bread", 1);
        System.out.println(usersBasket);
        System.out.println(stockList);
        ((StockItem)stockList.Items().get("car")).adjustStock(2000);
        ((StockItem)stockList.Items().get("car")).adjustStock(-1000);
        System.out.println(stockList);
    }


    public static int sellItem(Basket basket, String item, int quantity) {
        // retrieve the item from stock list
        StockItem stockItem = stockList.get(item);
        if(stockItem == null) {
            System.out.println("We don't sell " + item);
            return 0;
        }
        if(stockList.sellStock(item,quantity) != 0) {
            basket.addToBasket(stockItem,quantity);
            return quantity;
        }
        return 0;
    }
}
