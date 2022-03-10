import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        SalesManagement saleSystem = new SalesManagement();

        while (true) {
            System.out.println();
            System.out.println("Welcome to SalesManagement");
            System.out.println("1. Add products");
            System.out.println("2. Add users");
            System.out.println("3. Make order");
            System.out.println("4. Get product");
            System.out.println("5. Get user");
            System.out.println("6. Get product amount");
            System.out.println("7. Get all products list");
            System.out.println("8. Get all user list");
            System.out.println("9. Get all order list");
            System.out.println("0. Exit");
            System.out.println();
            try {
                System.out.print("Enter option (1-9): ");
                int option = scanner.nextInt();
                switch (option) {
                    case 1:
                        saleSystem.createProduct();
                        break;
                    case 2:
                        saleSystem.createUser();
                        break;
                    case 3:
                        saleSystem.createOrder();
                        break;
                    case 4:
                        saleSystem.getProduct();
                        break;
                    case 5:
                        saleSystem.getUser();
                        break;
                    case 6:
                        saleSystem.getAmountOfProduct();
                        break;
                    case 7:
                        saleSystem.getAllProducts();
                        break;
                    case 8:
                        saleSystem.getAllUsers();
                        break;
                    case 9:
                        saleSystem.getAllOrders();
                        break;
                    default: break;
                }
            } catch (InputMismatchException e) {
                System.out.println("Input must be integer");
                scanner.nextLine(); // to ignore incorrect input
            }
            catch (Exception e) {
                System.out.println(e.getMessage());
            }

            System.out.println("*************************");

        }
    }

}


