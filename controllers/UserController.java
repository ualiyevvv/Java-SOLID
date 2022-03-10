package controllers;

import entities.user.LoyalUser;
import entities.user.OrdinaryUser;
import entities.user.PrimeUser;
import entities.user.User;
import exceptions.NotFoundException;
import repositories.interfaces.IUserRepository;

import java.util.ArrayList;

public class UserController {
    private IUserRepository repo;

    public UserController(IUserRepository repo) {
        this.repo = repo;
    }

    public String createUser(int id, String name, String surname, double balance) {
        User user = new OrdinaryUser(id, name, surname, balance);

        boolean created = repo.createUser(user);

        return (created ? "User was created!" : "User creation was failed!");
    }

    public ArrayList<User> getAllUsers() {
        ArrayList<User> users = repo.getAllUsers();

        return users;
    }

    public User getUser(int id) throws NotFoundException {
        User user = repo.getUser(id);
        if (user == null){
            throw new NullPointerException("User was not found!");
        }

        return user;
    }


    public void switchToPrime(User ordinaryUser) {
        User primeUser = new PrimeUser(
                ordinaryUser.getId(),
                ordinaryUser.getName(),
                ordinaryUser.getSurname(),
                ordinaryUser.getBalance(),
                ordinaryUser.getOrderHistory(),
                ordinaryUser.getSpentBalance()
        );
        repo.removeUser(ordinaryUser.getId());
        repo.createUser(primeUser);
    }

    public void switchToLoyal(User primeUser) {
        User loyalUser = new LoyalUser(
                primeUser.getId(),
                primeUser.getName(),
                primeUser.getSurname(),
                primeUser.getBalance(),
                primeUser.getOrderHistory(),
                primeUser.getSpentBalance()
        );
        repo.removeUser(primeUser.getId());
        repo.createUser(loyalUser);
    }


}
