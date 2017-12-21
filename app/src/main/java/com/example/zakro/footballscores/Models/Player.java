package com.example.zakro.footballscores.Models;

import java.util.Date;

/**
 * Created by zakro on 12/5/17.
 */

public class Player
{
    private String name;
    private String position;
    private int jerseyNumber;
    private Date dateOfBirth;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public int getJerseyNumber() {
        return jerseyNumber;
    }

    public void setJerseyNumber(int jerseyNumber) {
        this.jerseyNumber = jerseyNumber;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    public Date getContractUntil() {
        return contractUntil;
    }

    public void setContractUntil(Date contractUntil) {
        this.contractUntil = contractUntil;
    }

    public int getMarketValue() {
        return marketValue;
    }

    public void setMarketValue(int marketValue) {
        this.marketValue = marketValue;
    }

    private String nationality;
    private Date contractUntil;
    private int marketValue;
}
