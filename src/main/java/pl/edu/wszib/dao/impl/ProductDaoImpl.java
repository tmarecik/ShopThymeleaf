package pl.edu.wszib.dao.impl;

import org.springframework.stereotype.Repository;
import pl.edu.wszib.dao.ProductDao;
import pl.edu.wszib.domain.Product;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class ProductDaoImpl implements ProductDao {

    private Map<Long, Product> productMap;
    private static Long id=1L;

    public ProductDaoImpl() {
        this.productMap = new HashMap<>();
        prepareProductList();
    }


    @Override
    public void saveProduct(Product product) {
        if (product.getId()<1){
            product.setId(id);
            id++;
        }
        productMap.put(product.getId(), product);
    }

    @Override
    public List<Product> getProducts() {
        return new ArrayList<>(productMap.values());
    }

    @Override
    public void removeProduct(Long id) {
        productMap.remove(id);
    }

    private void prepareProductList() {
        Product product = new Product();
        product.setName("Produkt1");
        product.setPrice(10);
        product.setQuantity(100);
        product.setAvailable(true);
        saveProduct(product);

        Product product2 = new Product();
        product2.setName("Produkt2");
        product2.setPrice(250);
        product2.setQuantity(200);
        product2.setAvailable(false);
        saveProduct(product2);
    }

    @Override
    public Product getById(Long id) {
        return productMap.get(id);
    }
}
