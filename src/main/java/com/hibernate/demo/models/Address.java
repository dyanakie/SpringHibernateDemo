package com.hibernate.demo.models;


import javax.persistence.*;

@Entity
@Table(name = "addresses")
public class Address {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "addressID")
    private int id;

    @Column(name = "AddressText")
    private String address;

    @Column(name="TownID")
    private int townId;

    @OneToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "addressID", nullable = false)
    private Employee employee;

    @OneToOne(fetch = FetchType.LAZY,
            cascade =  CascadeType.ALL,
            mappedBy = "address")
    private Town town;

    public Town getTown() {
        if(town == null){
            this.town = new Town();
        }
        return town;
    }

    public void setTown(Town town) {
        this.town = town;
    }

    public Address() {
    }

    public Address(int id, String address, int townId){
        this.id = id;
        this.address = address;
        this.townId = townId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAddress() {
        if(address == null){
            return "NONE";
        }
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getTownId() {
        return townId;
    }

    public void setTownId(int townId) {
        this.townId = townId;
    }

    @Override
    public String toString() {
        return getAddress();
    }
}
