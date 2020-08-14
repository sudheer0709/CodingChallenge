package org.example.entity;

public class NearestLocationDetails {

    private String name;
    private String address;
    private double distance;



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

    public double getDistance() {
        return distance;
    }

    public void setDistance(double distance) {
        this.distance = distance;
    }

    @Override
    public String toString() {
        return "Nearest location name is: "+ this.name + "\n"+", is at address "+ this.address+"\n"+ " and it is "+ this.distance+ " miles away";
    }
}
