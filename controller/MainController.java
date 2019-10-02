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
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import model.Country;
import model.Master;

/**
 * FXML Controller class
 *
 * @author Stanley Sie
 */
public class MainController {

    /**
     * Initializes the controller class.
     */
    
    @FXML
    private TableView table;
    @FXML
    private Button city, region, continent, language;
    @FXML
    private AnchorPane pane;
    
    private Master master;
    private Stage stage;
    private Country current;
    private TableColumn codes, names, continents, regions, capitals;
    
    public MainController(Master master, Stage stage) throws IOException {
        this.master = master;
        this.stage = stage;
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/Main.fxml"));
        loader.setController(this);
        Parent root = loader.load();
        Scene scene = new Scene(root);
        this.stage.setScene(scene);
        this.stage.setTitle("World Database");
        setData();
        this.stage.show();
    }
    
    public void initialize() {
        city.setOnAction(event -> {
            try {
                ListController list = new ListController(this.master, 0);
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        });
        continent.setOnAction(event -> {
            try {
                ListController list = new ListController(this.master, 1);
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        });
        region.setOnAction(event -> {
            try {
                ListController list = new ListController(this.master, 2);
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        });
        language.setOnAction(event -> {
            try {
                ListController list = new ListController(this.master, 3);
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        });
        table.setOnMouseClicked(event -> {
            current = (Country) table.getSelectionModel().getSelectedItem();
            try {
                CountryDataController controller = new CountryDataController(this.master, current);
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        });
        pane.setOnMouseClicked(event -> {
            current = null;
            table.getSelectionModel().clearSelection();
        });
    }    
    
    private void setData() {
        ObservableList<Country> countries = FXCollections.observableArrayList();
        countries = master.getCountries();
        codes = new TableColumn("Code");
        codes.setCellValueFactory(new PropertyValueFactory("code"));
        names = new TableColumn("Name");
        names.setCellValueFactory(new PropertyValueFactory("name"));
        continents = new TableColumn("Continent");
        continents.setCellValueFactory(new PropertyValueFactory("continent"));
        regions = new TableColumn("Region");
        regions.setCellValueFactory(new PropertyValueFactory("region"));
        capitals = new TableColumn("Capital");
        capitals.setCellValueFactory(new PropertyValueFactory("capitalName"));
        table.getColumns().setAll(codes, names, continents, regions, capitals);
        table.setItems(countries);
    }
}
