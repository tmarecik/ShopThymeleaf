package pl.edu.wszib.dao;

import pl.edu.wszib.domain.Product;

import java.util.List;

public interface ProductDao {
    List<Product> getProducts();
    void saveProduct(Product product);
}
