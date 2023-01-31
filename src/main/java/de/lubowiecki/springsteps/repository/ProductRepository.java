package de.lubowiecki.springsteps.repository;

import de.lubowiecki.springsteps.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

// CrudRepository<TypDerEntity, TypDerId> - Stellt einfache CRUD Funktionen bereit
// JpaRepository<TypDerEntity, TypDerId> - Stellt erweiterte CRUD Funktionen bereit
@Repository // Optional, da es bereits in den Eltern-Interfaces hinterlegt ist
public interface ProductRepository extends JpaRepository<Product, Long> {

    List<Product> findByName(String name);

    List<Product> findByNameContaining(String name);
    List<Product> findByNameContainingOrDescriptionContaining(String name, String desc);

}
