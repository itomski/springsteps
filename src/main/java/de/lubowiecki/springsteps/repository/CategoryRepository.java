package de.lubowiecki.springsteps.repository;

import de.lubowiecki.springsteps.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Long> {
}
