package com.agency.demo.models;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name="adverts")
public class Advertisement {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "title")
    private String title;

    @Column(name = "description")
    private String description;

    @Column(name="date_created")
    private LocalDate dateCreated;

    @OneToOne
    @JoinColumn(name="realtor_id", referencedColumnName = "id")
    private Realtor realtor;

    @OneToOne
    @JoinColumn(name="estate_id", referencedColumnName = "id")
    private Estate estate;

    public Advertisement(){}

    public Advertisement(String title, String description, Realtor realtor, Estate estate) {
        this.title = title;
        this.description = description;
        this.realtor = realtor;
        this.estate = estate;
        this.dateCreated = LocalDate.now();
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDate getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(LocalDate dateCreated) {
        this.dateCreated = dateCreated;
    }

    public Realtor getRealtor() {
        return realtor;
    }

    public void setRealtor(Realtor realtor) {
        this.realtor = realtor;
    }

    public Estate getEstate() {
        return estate;
    }

    public void setEstate(Estate estate) {
        this.estate = estate;
    }
}
