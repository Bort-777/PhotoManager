/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package photomanager;

import javafx.application.Application;
import javafx.stage.Stage;

/**
 *
 * @author Администратор
 */
public class PhotoManager extends Application {
    
    @Override
    public void start(Stage primaryStage) {
        Controller control = new Controller();
        
        ViewControl view = new ViewControl(primaryStage);
        control.setView(view);
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
