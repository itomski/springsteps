package de.lubowiecki.springsteps;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

// Integer ist der Wrappertyp für die id (int) von Product
@Repository
public interface ProductRepository extends JpaRepository<Product, Integer> {

    // Die Methoden des Repository werden automatisch von Hibernate bereitgestellt
    // Es muss nichts ausprogrammiert werden

}
