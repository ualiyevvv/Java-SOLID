package entities.user;

import entities.Order;
import exceptions.NotEnoughMoneyException;

import java.util.ArrayList;

public class PrimeUser extends User {
    public PrimeUser(int id, String name, String surname, double balance, ArrayList<Order> orderHistory, double spentBalance) {
        super(id, name, surname, balance);
        setOrderHistory(orderHistory);
        setSpentBalance(spentBalance);
        setStatus("prime");
    }

    @Override
    public double buy(double price, int quantity) throws NotEnoughMoneyException {
        double total_sum = price * quantity;
        if (total_sum > getBalance()) {
            throw new NotEnoughMoneyException("You didn't have enough money");
        }
        if(quantity>1){
            total_sum *= 0.95;
        }
        setBalance(getBalance()-total_sum);
        setSpentBalance(getSpentBalance()+total_sum);

        return getBalance();
    }

}
