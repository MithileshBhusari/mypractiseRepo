package com.mtb.springboot.mybatis.customer.model;

public class Address {

    private int addressId;
    private String  city;
    private String country;
    private String streetNr;
    private String plotno;


    private String customerId;
public Address(){

}
   public Address(String plotno,String city, String country, String streetNr,String customerId) {
        this.plotno=plotno;
        this.city = city;
        this.country = country;
        this.streetNr = streetNr;
        this.customerId=customerId;
    }


    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }
    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getStreetNr() {
        return streetNr;
    }

    public void setStreetNr(String streetNr) {
        this.streetNr = streetNr;
    }

    public String getPlotno() {
        return plotno;
    }

    public void setPlotno(String plotno) {
        this.plotno = plotno;
    }


    public int getAddressId() {
        return addressId;
    }

    public void setAddressId(int addressId) {
        this.addressId = addressId;
    }
}
