package dio.me.api_decolatech_2025.repository;

import dio.me.api_decolatech_2025.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository  extends JpaRepository<User, Long> {
}
