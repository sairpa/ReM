package com.ps3.rem.Classes;

public class User_C {

    String Name;
    String address;
    String pincode;

    public User_C(String name, String address, String pincode, String phone, String email) {
        Name = name;
        this.address = address;
        this.pincode = pincode;
        Phone = phone;
        Email = email;
    }

    String Phone;

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPincode() {
        return pincode;
    }

    public void setPincode(String pincode) {
        this.pincode = pincode;
    }

    public String getPhone() {
        return Phone;
    }

    public void setPhone(String phone) {
        Phone = phone;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    String Email;



}
