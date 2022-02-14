import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class ShoppingCart {

    private final List<LineItem> cart = new ArrayList<>();
    private int totalPrice = 0;
    private int quantity = 0;


    public void addItem(LineItem item) {
        totalPrice += item.getPrice() * item.getQuantity();
        quantity += item.getQuantity();
        cart.add(item);
    }

    public List<LineItem> getCart() {
        return cart;
    }

    public int getTotalPrice() {
        return totalPrice;
    }

    public int getQuantity() {
        return quantity;
    }


    public List<LineItem> itemizedList() {
        List<LineItem> result = new ArrayList<>();
        for(LineItem item : cart){
            if(result.contains(item)){
                result.get(result.indexOf(item)).setQuantity(result.get(result.indexOf(item)).getQuantity() + item.getQuantity());
            }else{
                result.add(item);
            }
        }
        return result;
    }


    public List<LineItem> oneSalesItem() {
        return cart.stream().filter(LineItem::isOneSale).collect(Collectors.toList());
    }
}
