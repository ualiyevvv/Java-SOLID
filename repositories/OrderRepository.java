package repositories;

import entities.Order;
import repositories.interfaces.IOrderRepository;

import java.util.ArrayList;

public class OrderRepository implements IOrderRepository {
    private ArrayList<Order> orders;

    public OrderRepository(ArrayList<Order> orders) {
        this.orders = orders;
    }

    @Override
    public boolean createOrder(Order order) {
        try {
            orders.add(order);

            return true;
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return false;
    }

    @Override
    public ArrayList<Order> getAllOrders() {
        try {
            return orders;
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return null;
    }
}
