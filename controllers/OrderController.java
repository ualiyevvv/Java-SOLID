package controllers;

import entities.Order;
import exceptions.IncorrectQuantityException;
import repositories.interfaces.IOrderRepository;

import java.util.ArrayList;

public class OrderController {
    private IOrderRepository repo;

    public OrderController(IOrderRepository repo) {
        this.repo = repo;
    }

    public Order createOrder(int userId, String productName, int quantity) throws IncorrectQuantityException {
        if (quantity < 1) {
            throw new IncorrectQuantityException("Please enter correct quantity!");
        }
        Order order = new Order(userId, productName, quantity);

        boolean created = repo.createOrder(order);

        return (created ? order : null);
    }

    public ArrayList<Order> getAllOrders() {
        ArrayList<Order> orders = repo.getAllOrders();

        return orders;
    }

}
