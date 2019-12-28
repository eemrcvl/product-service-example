package demo.service;

import demo.domain.Product;

import java.util.List;

public interface ProductService {
    Product saveProduct(Product product);

    Product updateProduct(Product product);

  //  Product findProductByName(String name);

    void deleteProduct(Integer id);

    List<Product> getProducts();
}
