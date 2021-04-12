package com.agency.demo.models;

import com.agency.demo.enums.UserRole;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name="realtors")
public class Realtor {

    //Private section

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "rating")
    private int rating;

    @OneToOne
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private User user;

    @OneToMany(mappedBy = "realtor")
    Set<Advertisement> adverts;

    //End of Private section
    public Realtor(){

    }

    public Realtor(User user) {
        this.user = user;
        rating = 0;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
        this.user.setRole(UserRole.REALTOR);
    }
}
