package com.agency.demo.models;

import com.agency.demo.enums.EstateStatus;
import com.agency.demo.enums.EstateType;

import javax.persistence.*;

@Entity
@Table(name = "estates")
public class Estate {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private long id;

    @Column(name = "area")
    private float area;

    @Column(name ="cost")
    private float cost;

    @Column(name = "floors")
    private int floors;

    @Column(name = "rooms")
    private int rooms;

    @Column(name = "address")
    private String address;

    @Column(name = "state")
    @Enumerated(EnumType.STRING)
    private EstateStatus status;

    @Column(name = "type")
    @Enumerated(EnumType.STRING)
    private EstateType type;

    public Estate(){}

    public Estate(float area,
                  float cost,
                  int floors,
                  int rooms,
                  String address,
                  EstateStatus status) {
        this.area = area;
        this.cost = cost;
        this.floors = floors;
        this.rooms = rooms;
        this.address = address;
        this.status = status;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public float getArea() {
        return area;
    }

    public void setArea(float area) {
        this.area = area;
    }

    public float getCost() {
        return cost;
    }

    public void setCost(float cost) {
        this.cost = cost;
    }

    public int getFloors() {
        return floors;
    }

    public void setFloors(int floors) {
        this.floors = floors;
    }

    public int getRooms() {
        return rooms;
    }

    public void setRooms(int rooms) {
        this.rooms = rooms;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public EstateStatus getStatus() {
        return status;
    }

    public void setStatus(EstateStatus status) {
        this.status = status;
    }

    public EstateType getType() {
        return type;
    }

    public void setType(EstateType type) {
        this.type = type;
    }
}
