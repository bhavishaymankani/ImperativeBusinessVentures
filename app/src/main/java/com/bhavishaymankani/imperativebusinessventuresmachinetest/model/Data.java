package com.bhavishaymankani.imperativebusinessventuresmachinetest.model;

import java.io.Serializable;

public class Data implements Serializable {
    private String name;
    private String mobileNumber;
    private String email;
    private String address;
    private String correspondingAddress;
    private String motherName;
    private String fatherName;
    private String occupation;
    private Integer occupationPosition;

    public Integer getOccupationPosition() {
        return occupationPosition;
    }

    public void setOccupationPosition(Integer occupationPosition) {
        this.occupationPosition = occupationPosition;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMobileNumber() {
        return mobileNumber;
    }

    public void setMobileNumber(String mobileNumber) {
        this.mobileNumber = mobileNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCorrespondingAddress() {
        return correspondingAddress;
    }

    public void setCorrespondingAddress(String correspondingAddress) {
        this.correspondingAddress = correspondingAddress;
    }

    public String getMotherName() {
        return motherName;
    }

    public void setMotherName(String motherName) {
        this.motherName = motherName;
    }

    public String getFatherName() {
        return fatherName;
    }

    public void setFatherName(String fatherName) {
        this.fatherName = fatherName;
    }

    public String getOccupation() {
        return occupation;
    }

    public void setOccupation(String occupation) {
        this.occupation = occupation;
    }
}
