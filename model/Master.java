/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.sql.SQLException;
import javafx.collections.ObservableList;

/**
 *
 * @author Stanley Sie
 */
public class Master {
    private Service service;
    
    public Master() {
        service = new Service();
    }
    
    public ObservableList<Country> getCountries() {
        try {
            return service.getCountries();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return null;
    }
    
    public ObservableList<City> getCities() {
        try {
            return service.getCities();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return null;
    }
    
    public ObservableList<String> getContinents() {
        try {
            return service.getContinents();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return null;
    }
    
    public ObservableList<String> getRegions() {
        try {
            return service.getRegions();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return null;
    }
    
    public ObservableList<String> getLanguages() {
        try {
            return service.getLanguages();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return null;
    }
}
