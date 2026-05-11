package de.lubowiecki.springsteps;

import org.springframework.data.jpa.repository.JpaRepository;

// Long = Typ der ID
public interface ProductRepository extends JpaRepository<Product, Long> {
}
