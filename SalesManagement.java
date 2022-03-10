import controllers.OrderController;
import controllers.ProductController;
import controllers.UserController;
import entities.Order;
import entities.Product;
import entities.user.User;
import exceptions.NotEnoughMoneyException;
import exceptions.IncorrectQuantityException;
import exceptions.NotFoundException;
import repositories.*;

import java.util.ArrayList;
import java.util.Objects;
import java.util.Scanner;

public class SalesManagement {
    private ArrayList<Product> products;
    private ArrayList<Order> orders;
    private ArrayList<User> users;

    private UserController user_controller;
    private ProductController product_controller;
    private OrderController order_controller;

    private Scanner scanner;

    public SalesManagement() {
        products = new ArrayList<>();
        orders = new ArrayList<>();
        users = new ArrayList<>();

        scanner = new Scanner(System.in);

        user_controller = new UserController(new UserRepository(users));
        product_controller = new ProductController(new ProductRepository(products));
        order_controller = new OrderController(new OrderRepository(orders));
    }

    public void createProduct() {
        System.out.print("enter product id: ");
        int productId = scanner.nextInt();
        System.out.print("enter product name: ");
        String productName = scanner.next();
        System.out.print("enter quantity: ");
        int quantity = scanner.nextInt();
        System.out.print("enter price: ");
        double price = scanner.nextDouble();

        String response = product_controller.createProduct(productId, productName, quantity, price);
        System.out.println(response);
    }
    public void createUser() {
        System.out.print("enter user id: ");
        int id = scanner.nextInt();
        System.out.print("enter user name: ");
        String name = scanner.next();
        System.out.print("enter surname: ");
        String surname = scanner.next();
        System.out.print("enter balance: ");
        double balance = scanner.nextDouble();

        String response = user_controller.createUser(id, name, surname, balance);
        System.out.println(response);
    }
    public void getAllUsers() {
        System.out.println(user_controller.getAllUsers().toString());
    }
    public void getAllProducts() {
        System.out.println(product_controller.getAllProducts().toString());
    }
    public void getAllOrders() {
        System.out.println(order_controller.getAllOrders().toString());
    }
    public void getUser() throws NotFoundException {
        System.out.print("enter user id: ");
        int id = scanner.nextInt();

        System.out.println(user_controller.getUser(id));
    }
    public void getProduct() throws NotFoundException {
        System.out.print("enter product id: ");
        int id = scanner.nextInt();

        System.out.println(product_controller.getProduct(id));
    }
    public void getAmountOfProduct() {
        System.out.print("enter product id: ");
        int id = scanner.nextInt();

        System.out.println(product_controller.getAmountOfProduct(id));
    }

    public void createOrder() throws NotFoundException, IncorrectQuantityException, NotEnoughMoneyException {
        System.out.print("Enter user id: ");
        int user_id = scanner.nextInt();
        System.out.print("Enter product id: ");
        int product_id = scanner.nextInt();
        System.out.print("Enter quantity: ");
        int quantity = scanner.nextInt();

        User user = user_controller.getUser(user_id);
        Product product = product_controller.getProduct(product_id);
        if (product.getQuantity() < quantity) {
            throw new IncorrectQuantityException("The product is not in quantity");
        }
        double balance = user.buy(product.getPrice(), quantity);
        Order order = order_controller.createOrder(user_id, product.getName(), quantity);
        if (order != null ) System.out.println("Order was created!");
            else System.out.print("Order was created!");

        user.getOrderHistory().add(order);
        product.decreaseProductQuantity(quantity);
        System.out.println(" Balance = " + balance);

        if (user.getOrderHistory().size() >= 2 && !Objects.equals(user.getStatus(), "prime")) {
            user_controller.switchToPrime(user);
            System.out.println("you are prime user. congrats!");
        }
        if (user.getSpentBalance() >= 1000 && !Objects.equals(user.getStatus(), "loyal")) {
            user_controller.switchToLoyal(user);
            System.out.println("you are loyal user. congrats!");
        }

    }



}
