package demo.controller;


import demo.domain.Product;
import demo.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/product",produces = {"application/json"})
public class ProductRestController {

    private ProductService productService;
    @Autowired
    public ProductRestController(ProductService productService){
        this.productService=productService;
    }

    @RequestMapping(value = "/productlist",method = RequestMethod.GET)
    public List<Product> getProducts(){
        List<Product> productList=productService.getProducts();
        return productList;
    }
    @RequestMapping(value = "/add",method = RequestMethod.POST)
    public Product addProduct(@RequestBody Product product){
        Product newProduct=productService.saveProduct(product);
        return newProduct;
    }
    @RequestMapping(value = "/{id}",method = RequestMethod.PUT)
    public Product updateProduct(@RequestBody Product product){
        Product updatedProduct=productService.updateProduct(product);
        return updatedProduct;
    }
    @RequestMapping(value = "/{id}",method = RequestMethod.DELETE)
    public void deleteProductByID(@PathVariable("id") int id){
        productService.deleteProduct(id);
    }
}
