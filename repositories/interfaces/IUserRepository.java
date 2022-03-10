package repositories.interfaces;

import entities.user.User;

import java.util.ArrayList;

public interface IUserRepository {
    boolean createUser(User user);
    User getUser(int id);
    ArrayList<User> getAllUsers();
    boolean removeUser(int id);
}
