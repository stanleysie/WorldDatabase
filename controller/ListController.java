/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.IOException;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.stage.Stage;
import model.City;
import model.Master;

/**
 * FXML Controller class
 *
 * @author Stanley Sie
 */
public class ListController {

    /**
     * Initializes the controller class.
     */
    
    @FXML
    private Label title;
    @FXML
    private ListView list;
    
    private Master master;
    private Stage stage;
    
    public ListController(Master master, int index) throws IOException {
        this.master = master;
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/List.fxml"));
        loader.setController(this);
        Parent root = loader.load();
        Scene scene = new Scene(root);
        stage = new Stage();
        stage.setScene(scene);
        stage.setTitle("List");
        setData(index);
        stage.show();
    }
    
    public void initialize() {
        
    }    
    
    private void setData(int index) {
        ObservableList<String> names = FXCollections.observableArrayList();
        if(index == 0) {
            ObservableList<City> city = FXCollections.observableArrayList();
            city = master.getCities();
            for(int i = 0; i < city.size(); i++) {
                names.add(city.get(i).getName());
            }
            title.setText("List of Cities");
        } else if(index == 1) {
            names = master.getContinents();
            title.setText("List of Continents");
        } else if(index == 2) {
            names = master.getRegions();
            title.setText("List of Regions");
        } else if(index == 3) {
            names = master.getLanguages();
            title.setText("List of Languages");
        }
        list.setItems(names);
    }
}
