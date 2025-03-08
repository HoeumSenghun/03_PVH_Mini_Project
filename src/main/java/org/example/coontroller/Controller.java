package org.example.coontroller;
import java.util.ArrayList;
import java.util.List;

import org.example.Dao.ProductDao;
import org.example.Dao.ProductDaoImp;
import org.example.model.Product;
import org.example.view.ProductView;

public class ProductController {
    ProductDao productDao;
    ProductView productView;

    public ProductController() {
        productDao = new ProductDaoImp();
        productView = new ProductView();
    }

    public void addProduct() {
        Product product = productDao.insertProduct();
        productView.insertProduct(product);
    }

    public List<Product> getAllProducts() {
        return products;
    }

    public Product getProductById(int id) {
        return products.stream().filter(p -> p.getId() == id).findFirst().orElse(null);
    }

    public void updateProduct(int id, Product updatedProduct) {
        for (int i = 0; i < products.size(); i++) {
            if (products.get(i).getId() == id) {
                products.set(i, updatedProduct);
                break;
            }
        }
    }

    public void deleteProduct(int id) {
        products.removeIf(p -> p.getId() == id);
    }
}
