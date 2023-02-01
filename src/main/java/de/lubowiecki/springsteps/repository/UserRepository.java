package de.lubowiecki.springsteps.repository;

import de.lubowiecki.springsteps.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
