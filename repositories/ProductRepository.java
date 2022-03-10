package repositories;

import entities.Product;
import repositories.interfaces.IProductRepository;

import java.util.ArrayList;

public class ProductRepository implements IProductRepository {
    private ArrayList<Product> products;

    public ProductRepository(ArrayList<Product> products) {
        this.products = products;
    }

    @Override
    public boolean createProduct(Product product) {
        try {
            products.add(product);

            return true;
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        return false;
    }

    @Override
    public Product getProduct(int id) {
        try {
            for (Product product : products) {
                if (product.getId() == id) {

                    return product;
                }
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        return null;
    }

    @Override
    public ArrayList<Product> getAllProducts() {
        try {

            return products;
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return null;
    }
}
