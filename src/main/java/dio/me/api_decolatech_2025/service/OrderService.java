package dio.me.api_decolatech_2025.service;

import dio.me.api_decolatech_2025.model.Order;
import dio.me.api_decolatech_2025.model.Product;
import dio.me.api_decolatech_2025.model.User;
import dio.me.api_decolatech_2025.repository.OrderRepository;
import dio.me.api_decolatech_2025.repository.ProductRepository;
import dio.me.api_decolatech_2025.repository.UserRepository;
import dio.me.api_decolatech_2025.service.request.OrderRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class OrderService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private OrderRepository orderRepository;

    public List<Order> findAll() {
        return orderRepository.findAll();
    }

    public Order findById(Long id) {
        return orderRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Order not found"));
    }

    public Order createOrder(OrderRequest orderRequest) {
        User user = userRepository.findById(orderRequest.getUserId())
                .orElseThrow(() -> new RuntimeException("User not found"));

        Product product = productRepository.findById(orderRequest.getProductId())
                .orElseThrow(() -> new RuntimeException("Product not found"));

        Order order = new Order();
        order.setUser(user);
        order.setProduct(product);
        order.setQuantity(orderRequest.getQuantity());

        return orderRepository.save(order);
    }

    public Order updateOrder(Long id, OrderRequest orderRequest) {
        Order existingOrder = orderRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Order not found"));

        User user = userRepository.findById(orderRequest.getUserId())
                .orElseThrow(() -> new RuntimeException("User not found"));

        Product product = productRepository.findById(orderRequest.getProductId())
                .orElseThrow(() -> new RuntimeException("Product not found"));

        existingOrder.setUser(user);
        existingOrder.setProduct(product);
        existingOrder.setQuantity(orderRequest.getQuantity());

        return orderRepository.save(existingOrder);
    }

    public void deleteById(Long id) {
        orderRepository.deleteById(id);
    }
}