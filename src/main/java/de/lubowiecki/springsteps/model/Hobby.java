package de.lubowiecki.springsteps.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
public class Hobby implements Serializable {

    @Id
    @GeneratedValue
    private long id;

    @Column(length = 20)
    private String title;

    @ManyToMany(mappedBy = "hobbys")
    private Set<Profile> profiles;

    public Hobby() {
    }

    public Hobby(String title) {
        this.title = title;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Set<Profile> getProfiles() {
        return profiles;
    }

    public void addProfile(Profile profile) {
        if(profiles == null)
            profiles = new HashSet<Profile>();

        if(profiles.add(profile)) {
            profile.addHobby(this);
        }
    }
}
