package org.example.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;


@Entity
@ApiModel(description = "pharmacy location details")
public class PharmacyDetails {
    @Id
    @Column(columnDefinition = "VARCHAR(36)")
    @ApiModelProperty(notes = "zip code of a location")
    private int zip;

    @ApiModelProperty(notes = "name of a pharmacy")
    private String name;

    @ApiModelProperty(notes = "zpharmacy address")
    private String address;

    @ApiModelProperty(notes = "City in which pharmacy is located")
    private String city;

    @ApiModelProperty(notes = "state in which pharmacy is located")
    private String state;

    @ApiModelProperty(notes = "latitude of the current pharmacy")
    private double latitude;

    @ApiModelProperty(notes = "longitude of the current pharmacy")
    private double longitude;

    public PharmacyDetails(){

    }

    public PharmacyDetails(int zip, String name, String address, String city, String state, double latitude, double longitude) {
        this.zip = zip;
        this.name = name;
        this.address = address;
        this.city = city;
        this.state = state;
        this.latitude = latitude;
        this.longitude = longitude;
    }

    public int getZip() {
        return zip;
    }

    public void setZip(int  zip) {
        this.zip = zip;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    @Override
    public String toString() {
        return "PharmacyDetails{" +
                "zip=" + zip +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", city='" + city + '\'' +
                ", state='" + state + '\'' +
                ", latitude=" + latitude +
                ", longitude=" + longitude +
                '}';
    }
}
