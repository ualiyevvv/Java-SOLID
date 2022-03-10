package entities.user;

import entities.Order;
import exceptions.NotEnoughMoneyException;

import java.util.ArrayList;

public abstract class User {
    private int id;
    private String name;
    private String surname;
    private double balance;
    private double spentBalance;
    private String status;
    private ArrayList<Order> orderHistory;

    public User(int id, String name, String surname, double balance) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.balance = balance;
        orderHistory = new ArrayList<Order>();
        spentBalance = 0;
    }

    public abstract double buy(double price, int quantity) throws NotEnoughMoneyException;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public ArrayList<Order> getOrderHistory() {
        return orderHistory;
    }

    public void setOrderHistory(ArrayList<Order> orderHistory) {
        this.orderHistory = orderHistory;
    }

    public double getSpentBalance() {
        return spentBalance;
    }

    public void setSpentBalance(double spentBalance) {
        this.spentBalance = spentBalance;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "\nUser{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", balance=" + balance +
                ", spentBalance=" + spentBalance +
                ", status='" + status + '\'' +
                ", orderHistory=" + orderHistory +
                '}';
    }
}
