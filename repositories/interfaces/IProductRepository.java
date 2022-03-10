package repositories.interfaces;

import entities.Product;

import java.util.ArrayList;

public interface IProductRepository {
    boolean createProduct(Product product);
    Product getProduct(int id);
    ArrayList<Product> getAllProducts();
}
