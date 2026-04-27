package com.ecommerce.order_service.service;

import com.ecommerce.order_service.dto.ProductDTO;
import com.ecommerce.order_service.entity.Order;
import com.ecommerce.order_service.feign.ProductClient;
import com.ecommerce.order_service.feign.UserClient;
import com.ecommerce.order_service.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderService {

    @Autowired
    private OrderRepository repo;
    @Autowired
    private UserClient userClient;
    @Autowired
    private ProductClient productClient;

    public Order placeOrder(Order order) {

        // 👤 validate user
        userClient.getUser(order.getUserId());

        // 📦 get product
        ProductDTO product = productClient.getProduct(order.getProductId());

        // ❗ check stock
        if (product.getQuantity() < order.getQuantity()) {
            throw new RuntimeException("Not enough stock");
        }

        // 💰 calculate total
        double total = product.getPrice() * order.getQuantity();
        order.setTotalPrice(total);

        // 📉 reduce stock
        product.setQuantity(product.getQuantity() - order.getQuantity());
        productClient.updateProduct(product.getId(), product);

        // 🧾 save order
        return repo.save(order);
    }
}