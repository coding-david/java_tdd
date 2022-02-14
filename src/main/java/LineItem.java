public class LineItem{

    private int price;
    private int quantity;
    private boolean isOneSale;

    public LineItem(int price,int quantity,boolean isOneSale) {
        this.price = price;
        this.quantity = quantity;
        this.isOneSale = isOneSale;
    }

    public int getPrice() {
        return price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public boolean isOneSale() {
        return isOneSale;
    }
}
