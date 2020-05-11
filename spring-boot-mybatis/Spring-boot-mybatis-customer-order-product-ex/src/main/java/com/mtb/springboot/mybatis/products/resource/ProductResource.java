package com.mtb.springboot.mybatis.products.resource;

import com.mtb.springboot.mybatis.orders.model.PurchaseOrder;
import com.mtb.springboot.mybatis.products.model.Product;
import com.mtb.springboot.mybatis.products.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/customers/{customerId}/orders/{orderId}/products/")
public class ProductResource {

    @Autowired
    private ProductService productService;

    @GetMapping("/getAllProducts")
    public List<Product> getAllProducts(@PathVariable int customerId, @PathVariable int orderId) {
        return productService.getAllProducts(customerId,orderId);
    }


    @GetMapping("/getProduct/{productId}")
    public Product getProduct(@PathVariable int customerId,@PathVariable int orderId,@PathVariable int productId) {
        return productService.getProduct(customerId,orderId,productId);
    }

    @PostMapping("/addProduct")
    private void addProduct(@RequestBody Product product, @PathVariable int customerId,@PathVariable int orderId) {
        productService.addOrder(product,customerId,orderId);
    }


    @DeleteMapping("/{productId}")
    private void deleteOrder(@PathVariable int orderId,@PathVariable int productId) {
        productService.deleteOrder(orderId,productId);
    }



}
