package entities;

public class Order {
    private int userId;
    private String productName;
    private int quantity;

    public Order(int userId, String productName, int quantity) {
        this.userId = userId;
        this.productName = productName;
        this.quantity = quantity;
    }

    public int getUserIdInOrder() {return userId;}
    public void setUserIdInOrder(int userId) {this.userId = userId;}
    public String getProductNameInOrder() {return productName;}
    public void setProductNameInOrder(String productName) {this.productName = productName;}
    public int getProductQuantityInOrder() {return quantity;}
    public void setProductQuantityInOrder(int quantity) {this.quantity = quantity;}

    @Override
    public String toString() {
        return "\nOrder{" +
                "userId=" + userId +
                ", productName='" + productName + '\'' +
                ", quantity=" + quantity +
                '}';
    }
}
