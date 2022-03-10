package entities.user;

import exceptions.NotEnoughMoneyException;

public class OrdinaryUser extends User {
    public OrdinaryUser(int id, String name, String surname, double balance) {
        super(id, name, surname, balance);
        setStatus("ordinary");
    }

    @Override
    public double buy(double price, int quantity) throws NotEnoughMoneyException {
        double total_sum = price * quantity;
        if (total_sum > getBalance()) {
            throw new NotEnoughMoneyException("You didn't have enough money");
        }
        setBalance(getBalance()-total_sum);
        setSpentBalance(getSpentBalance()+total_sum);

        return getBalance();
    }


}
