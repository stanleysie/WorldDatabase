/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 *
 * @author Stanley Sie
 */
public class Service {
    private JDBCConnection database;
    
    public Service() {
        database = new JDBCConnection();
    }
    
    public ObservableList<Country> getCountries() throws SQLException {
        ObservableList<Country> country = FXCollections.observableArrayList();
        Connection connection = database.create();
        String query = "SELECT * FROM country "
                        + "INNER JOIN city ON country.Code = city.CountryCode "
                        + "INNER JOIN countrylanguage ON country.Code = countrylanguage.CountryCode "
                        + "WHERE countrylanguage.IsOfficial = 'T' AND country.Capital = city.ID";
        PreparedStatement statement = connection.prepareStatement(query);
        try {
            ResultSet rs = statement.executeQuery();
            while(rs.next()) {
                Country c = new Country(rs.getString("Code"));
                City cc = new City(rs.getInt("ID"), rs.getString("CityName"), rs.getInt("CityPopulation"), rs.getString("Code"));
                if(!country.contains(c)) {
                    c.setName(rs.getString("CountryName"));
                    c.setContinent(rs.getString("Continent"));
                    c.setRegion(rs.getString("Region"));
                    c.setGovernmentName(rs.getString("GovernmentForm"));
                    c.setSurfaceArea(rs.getFloat("SurfaceArea"));
                    c.setPopulation(rs.getInt("CountryPopulation"));
                    c.setCapital(cc);
                    c.setLifeExpectancy(rs.getFloat("LifeExpectancy"));
                    c.setLanguage(rs.getString("Language").trim());
                    country.add(c);
                } else {
                    int index = country.indexOf(c);
                    country.get(index).setLanguage(rs.getString("Language").trim());
                }
            }
            return country;
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if(statement != null) statement.close();
            if(connection != null) connection.close();
        }
        return null;
    }
    
    public ObservableList<City> getCities() throws SQLException {
        ObservableList<City> city = FXCollections.observableArrayList();
        Connection connection = database.create();
        String query = "SELECT * FROM city ORDER BY CityName";
        PreparedStatement statement = connection.prepareStatement(query);
        try {
            ResultSet rs = statement.executeQuery();
            while(rs.next()) {
                City c = new City(rs.getInt("ID"), rs.getString("CityName"), rs.getInt("CityPopulation"), rs.getString("CountryCode"));
                city.add(c);
            }
            return city;
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if(statement != null) statement.close();
            if(connection != null) connection.close();
        }
        return null;
    }
    
    public ObservableList<String> getContinents() throws SQLException {
        ObservableList<String> continent = FXCollections.observableArrayList();
        Connection connection = database.create();
        String query = "SELECT DISTINCT(Continent) FROM country ORDER BY Continent";
        PreparedStatement statement = connection.prepareStatement(query);
        try {
            ResultSet rs = statement.executeQuery();
            while(rs.next()) {
                continent.add(rs.getString("Continent"));
            }
            return continent;
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if(statement != null) statement.close();
            if(connection != null) connection.close();
        }
        return null;
    }
    
    public ObservableList<String> getRegions() throws SQLException {
        ObservableList<String> region = FXCollections.observableArrayList();
        Connection connection = database.create();
        String query = "SELECT DISTINCT(Region) FROM country ORDER BY Region";
        PreparedStatement statement = connection.prepareStatement(query);
        try {
            ResultSet rs = statement.executeQuery();
            while(rs.next()) {
                region.add(rs.getString("Region"));
            }
            return region;
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if(statement != null) statement.close();
            if(connection != null) connection.close();
        }
        return null;
    }
    
    public ObservableList<String> getLanguages() throws SQLException  {
        ObservableList<String> language = FXCollections.observableArrayList();
        Connection connection = database.create();
        String query = "SELECT DISTINCT(Language) FROM countrylanguage ORDER BY Language";
        PreparedStatement statement = connection.prepareStatement(query);
        try {
            ResultSet rs = statement.executeQuery();
            while(rs.next()) {
                language.add(rs.getString("Language"));
            }
            return language;
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if(statement != null) statement.close();
            if(connection != null) connection.close();
        }
        return null;
    }
}
