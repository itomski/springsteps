package de.lubowiecki.springsteps.repository;

import de.lubowiecki.springsteps.model.Profile;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProfileRepository extends JpaRepository<Profile, Long> {
}
