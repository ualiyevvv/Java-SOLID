package controllers;

import entities.Product;
import exceptions.IncorrectQuantityException;
import exceptions.NotFoundException;
import repositories.interfaces.IProductRepository;

import java.util.ArrayList;

public class ProductController {
    private IProductRepository repo;

    public ProductController(IProductRepository repo) {
        this.repo = repo;
    }

    public String createProduct(int id, String name, int quantity, double price) {
        Product product = new Product(id, name, quantity, price);

        boolean created = repo.createProduct(product);

        return (created ? "Product was created!" : "Product creation was failed!");
    }

    public ArrayList<Product> getAllProducts() {
        ArrayList<Product> products = repo.getAllProducts();

        return products;
    }

    public Product getProduct(int id) throws NotFoundException {
        Product product = repo.getProduct(id);
        if (product == null ) {
            throw new NotFoundException("Product was not found");
        }

        return product;
    }

    public String getAmountOfProduct(int id) {
        Product product = repo.getProduct(id);

        return (product == null ? "Product was not found!" : "Amount of product left: " + product.getQuantity());
    }

}
