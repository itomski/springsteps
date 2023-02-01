package de.lubowiecki.springsteps.repository;

import de.lubowiecki.springsteps.model.Hobby;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HobbyRepository extends JpaRepository<Hobby, Long> {
}
