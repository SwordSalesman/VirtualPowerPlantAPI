package com.virtualPowerPlantAPI.model;

import javax.persistence.*;

/*
    Battery
    This class houses the attributes of a battery.
    The ID field has been removed, but only commented out should it be needed later.
 */
@Entity // Tells Java to make Battery a persistent object in databases
@Table // Defines this class as a representation of a table in the db
public class Battery {
//    @Id // Makes this field a primary ID in the database table
//    @GeneratedValue (strategy = GenerationType.AUTO) // Tells the database to auto generate the ID
//    private Integer id;
    @Id
    @Column(length = 100)
    private String name;
    private Integer postcode;
    private Double wattCap;

    public Battery() {
    }

    public Battery(String name, Integer postcode, Double wattCap) {
        this.name = name;
        this.postcode = postcode;
        this.wattCap = wattCap;
    }

//    public Integer getId() {
//        return id;
//    }
//
//    public void setId(Integer id) {
//        this.id = id;
//    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getPostcode() {
        return postcode;
    }

    public void setPostcode(Integer postcode) {
        this.postcode = postcode;
    }

    public Double getWattCap() {
        return wattCap;
    }

    public void setWattCap(Double wattCap) {
        this.wattCap = wattCap;
    }

    @Override
    public String toString() {
        return "Battery{" +
//                "id=" + id +
                "name='" + name + '\'' +
                ", postcode=" + postcode +
                ", wattCap=" + wattCap +
                '}';
    }
}
