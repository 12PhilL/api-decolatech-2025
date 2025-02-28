package dio.me.api_decolatech_2025.repository;

import dio.me.api_decolatech_2025.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
}
