/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.IOException;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import model.Country;
import model.Master;

/**
 * FXML Controller class
 *
 * @author Stanley Sie
 */
public class CountryDataController {

    /**
     * Initializes the controller class.
     */
    
    @FXML
    private Label code, name, capital, continent, region, government, surface, population, life, language;
    
    private Master master;
    private Country country;
    private Stage stage;
    
    public CountryDataController(Master master, Country country) throws IOException {
        this.master = master;
        this.country = country;
        stage = new Stage();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/CountryData.fxml"));
        loader.setController(this);
        Parent root = loader.load();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.setTitle("Country Data");
        setData();
        stage.show();
    }
    
    public void initialize() {
        
    }    
    
    private void setData() {
        code.setText(country.getCode());
        name.setText(country.getName());
        capital.setText(country.getCapital().getName());    
        continent.setText(country.getContinent());
        region.setText(country.getRegion());
        population.setText("" + country.getPopulation());
        government.setText(country.getGovernmentName());
        surface.setText("" + country.getSurfaceArea());
        life.setText("" + country.getLifeExpectancy());
        for(int i = 0; i < country.getLanguage().size(); i++) {
            language.setText(language.getText() + country.getLanguage().get(i) + "\n");
        }
    }
}
