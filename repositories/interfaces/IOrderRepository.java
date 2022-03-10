package repositories.interfaces;

import entities.Order;

import java.util.ArrayList;

public interface IOrderRepository {
    boolean createOrder(Order order);
    ArrayList<Order> getAllOrders();
}
