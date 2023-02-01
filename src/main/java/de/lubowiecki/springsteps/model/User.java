package de.lubowiecki.springsteps.model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
public class User implements Serializable {

    @Id
    @GeneratedValue
    private long id;

    @Column(length = 50, unique = true)
    private String email;

    @Column(length = 100)
    private String password;

    // cascade = CascadeType.ALL, Aktionen mit User werden auch mit dem Profil durchgeführt
    @OneToOne(cascade = CascadeType.ALL)
    private Profile profile;

    public User() {
    }

    public User(String email, String password) {
        this.email = email;
        this.password = password;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Profile getProfile() {
        return profile;
    }

    public void setProfile(Profile profile) {
        this.profile = profile;
    }
}
