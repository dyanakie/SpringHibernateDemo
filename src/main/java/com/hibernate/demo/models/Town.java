package com.hibernate.demo.models;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "towns")
public class Town {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "TownID")
    private int id;

    @Column(name = "Name")
    private String name;

    /*@OneToMany(fetch = FetchType.LAZY)
    @JoinColumn(name = "TownID", nullable = false)
    private List<Address> addresses;

    public List<Address> getAddresses() {
        return addresses;
    }

    public void setAddresses(List<Address> addresses) {
        this.addresses = addresses;
    }*/

    public Town(){

    }

    public Town(int id, String name){
        this.id = id;
        this.name = name;
    }

    public Town(String name){
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        if(this.name == null){
            return "NONE";
        }
        return this.getName();
    }
}
