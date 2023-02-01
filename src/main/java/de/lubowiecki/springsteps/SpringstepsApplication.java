package de.lubowiecki.springsteps;

import de.lubowiecki.springsteps.model.Category;
import de.lubowiecki.springsteps.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringstepsApplication implements CommandLineRunner {

    @Autowired
    private CategoryRepository categoryRepository;

    @Value("${db.reset}")
    private boolean dbReset;

    public static void main(String[] args) {
        SpringApplication.run(SpringstepsApplication.class, args);
    }


    @Override // Wir initial beim Start der Anwendung ausgeführt
    public void run(String... args) throws Exception {
        if(dbReset) {
            categoryRepository.deleteAll(); // Löscht alte Daten
            categoryRepository.save(new Category("Spielzeug"));
            categoryRepository.save(new Category("Kleidung"));
            categoryRepository.save(new Category("Werkzeug"));
            categoryRepository.save(new Category("Sonstiges"));
        }
    }
}
