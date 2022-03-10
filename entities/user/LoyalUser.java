package entities.user;

import entities.Order;
import exceptions.NotEnoughMoneyException;

import java.util.ArrayList;

public class LoyalUser extends User {
    private double cashback;

    public LoyalUser(int id, String name, String surname, double balance, ArrayList<Order> orderHistory, double spentBalance) {
        super(id, name, surname, balance);
        setOrderHistory(orderHistory);
        setSpentBalance(spentBalance);
        setStatus("loyal");
        cashback = 0.06;
    }

    @Override
    public double buy(double price, int quantity) throws NotEnoughMoneyException {
        double total_sum = price * quantity;
        if (total_sum > getBalance()) {
            throw new NotEnoughMoneyException("You didn't have enough money");
        }

        setBalance(getBalance()-(total_sum*(1 - this.cashback)));
        setSpentBalance(getSpentBalance()+total_sum);

        if (getOrderHistory().size() % 10 == 0) {
            increaseCashback();
        }
        return getBalance();
    }

    public void increaseCashback() {
        if (cashback != 0.1) {
            this.cashback += 0.01;
            System.out.println("**** Your cashback increased by 1% ****");
        }

    }
}
