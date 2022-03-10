package repositories;

import entities.user.User;
import repositories.interfaces.IUserRepository;

import java.util.ArrayList;

public class UserRepository implements IUserRepository {
    private ArrayList<User> users;

    public UserRepository(ArrayList<User> users) {
        this.users = users;
    }

    @Override
    public boolean createUser(User user) {
        try {
            users.add(user);

            return true;
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        return false;
    }

    @Override
    public User getUser(int id) {
        try {
            for (User user : users) {
                if (user.getId() == id) {

                    return user;
                }
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        return null;
    }

    @Override
    public ArrayList<User> getAllUsers() {
        try {

            return users;
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        return null;
    }

    @Override
    public boolean removeUser(int id) {
        try {
            for (int i = 0; i < users.size(); i++) {
                if (users.get(i).getId() == (id)) {
                    users.remove(i);
                    return true;
                }
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return false;
    }

}
