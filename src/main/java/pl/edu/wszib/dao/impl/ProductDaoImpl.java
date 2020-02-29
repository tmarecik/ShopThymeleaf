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

    private void prepareProductList() {
        Product product = new Product();
        product.setName("Produkt1");
        product.setPrice(10);
        product.setQuantity(100);
        product.setAvailable(true);
        saveProduct(product);

        Product product2 = new Product();
        product.setName("Produkt2");
        product.setPrice(250);
        product.setQuantity(200);
        product.setAvailable(false);
        saveProduct(product2);
    }

}
