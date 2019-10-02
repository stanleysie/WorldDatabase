/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 *
 * @author Stanley Sie
 */
public class Country {
    private String code, name, continent, region, governmentName, capitalName;
    private float surfaceArea, lifeExpectancy;
    private int population;
    private City capital;
    private ObservableList<String> language;
    
    public Country(String code) {
        this.code = code;
        this.language = FXCollections.observableArrayList();
    }
    
    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getContinent() {
        return continent;
    }

    public void setContinent(String continent) {
        this.continent = continent;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public String getGovernmentName() {
        return governmentName;
    }

    public void setGovernmentName(String governmentName) {
        this.governmentName = governmentName;
    }

    public City getCapital() {
        return capital;
    }

    public void setCapital(City capital) {
        this.capital = capital;
        this.capitalName = capital.getName();
    }
    
    public float getSurfaceArea() {
        return surfaceArea;
    }

    public void setSurfaceArea(float surfaceArea) {
        this.surfaceArea = surfaceArea;
    }

    public float getLifeExpectancy() {
        return lifeExpectancy;
    }

    public void setLifeExpectancy(float lifeExpectancy) {
        this.lifeExpectancy = lifeExpectancy;
    }

    public int getPopulation() {
        return population;
    }

    public void setPopulation(int population) {
        this.population = population;
    }

    public ObservableList<String> getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        if(this.language == null) {
            this.language = FXCollections.observableArrayList();
        } 
        this.language.add(language);
    }
    
    public String getCapitalName() {
        return capitalName;
    }
    
    @Override
    public boolean equals(Object obj) {
        Country c = (Country) obj;
        if(c.getCode().equalsIgnoreCase(this.code)) {
            return true;
        }
        return false;
    }
}
