package dio.me.api_decolatech_2025.repository;

import dio.me.api_decolatech_2025.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Long> {
}
