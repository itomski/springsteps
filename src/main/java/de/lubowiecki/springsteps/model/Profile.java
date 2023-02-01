package de.lubowiecki.springsteps.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Profile implements Serializable {

    @Id
    @GeneratedValue
    private long id;

    @Enumerated(EnumType.STRING)
    private Gender gender;

    @Column(length = 50)
    private String firstname;

    @Column(length = 50)
    private String lastname;

    @ManyToMany
    private Set<Hobby> hobbys;

    public Profile() {
    }

    public Profile(Gender gender, String firstname, String lastname) {
        this.gender = gender;
        this.firstname = firstname;
        this.lastname = lastname;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public Set<Hobby> getHobbys() {
        return hobbys;
    }

    public void addHobby(Hobby hobby) {

        if(hobbys == null)
            hobbys = new HashSet<Hobby>();

        if(hobbys.add(hobby)) {
            hobby.addProfile(this);
        }
    }
}
