package com.mtb.springboot.mybatis.products.service;

import com.mtb.springboot.mybatis.orders.model.PurchaseOrder;
import com.mtb.springboot.mybatis.products.mapper.ProductMapper;
import com.mtb.springboot.mybatis.products.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    @Autowired
    private ProductMapper productMapper;

    public List<Product> getAllProducts(int customerId, int orderId) {
       return  productMapper.getAllProducts(customerId,orderId);
    }

    public Product getProduct(int customerId, int orderId, int productId) {
        return productMapper.getProduct(customerId,orderId,productId);
    }

    public void addOrder(Product product, int customerId, int orderId) {
        productMapper.addOrder(product,customerId,orderId);
    }

    public void deleteOrder(int orderId, int productId) {
        productMapper.deleteOrder(orderId,productId);
    }
}
