package de.lubowiecki.springsteps;

import de.lubowiecki.springsteps.model.*;
import de.lubowiecki.springsteps.repository.CategoryRepository;
import de.lubowiecki.springsteps.repository.HobbyRepository;
import de.lubowiecki.springsteps.repository.ProfileRepository;
import de.lubowiecki.springsteps.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Arrays;

@SpringBootApplication
public class SpringstepsApplication implements CommandLineRunner {

    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private HobbyRepository hobbyRepository;

    @Autowired
    private ProfileRepository profileRepository;

    @Value("${db.reset.category}")
    private boolean categoryReset;

    @Value("${db.reset.user}")
    private boolean userReset;

    public static void main(String[] args) {
        SpringApplication.run(SpringstepsApplication.class, args);
    }


    @Override // Wir initial beim Start der Anwendung ausgeführt
    public void run(String... args) throws Exception {
        if(categoryReset) {
            categoryRepository.deleteAll(); // Löscht alte Daten
            categoryRepository.save(new Category("Spielzeug"));
            categoryRepository.save(new Category("Kleidung"));
            categoryRepository.save(new Category("Werkzeug"));
            categoryRepository.save(new Category("Sonstiges"));
        }

        if(userReset) {
            userRepository.deleteAll();
            hobbyRepository.deleteAll();

            User user = new User("p.parker@shield.org", "sehrGeheim#123");
            Profile profile = new Profile(Gender.MALE, "Peter", "Parker");
            user.setProfile(profile);
            userRepository.save(user);

            Hobby h1 = new Hobby("Kochen");
            Hobby h2 = new Hobby("Programmieren");
            Hobby h3 = new Hobby("Origami");

            // 3 Objekte auf mit einer Anweisung speichern
            hobbyRepository.saveAll(Arrays.asList(h1, h2, h3));
            profile.addHobby(h1);
            profile.addHobby(h2);
            profile.addHobby(h3);

            profileRepository.save(profile);
        }
    }
}
