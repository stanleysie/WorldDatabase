/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package driver;

import controller.MainController;
import java.io.IOException;
import javafx.application.Application;
import javafx.stage.Stage;
import model.Master;

/**
 *
 * @author Stanley Sie
 */
public class Driver extends Application {
    
    @Override
    public void start(Stage primaryStage) throws IOException {
        Master master = new Master();
        MainController main = new MainController(master, primaryStage);
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
