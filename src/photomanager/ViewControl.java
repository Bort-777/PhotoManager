/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package photomanager;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 *
 * @author Администратор
 */
class ViewControl {

    private final Stage primaryStage;

    ViewControl(Stage primaryStage) {
        this.primaryStage = primaryStage;
    }

    void create(Controller controller) {
        Parent root = null;
        FXMLLoader loader = new FXMLLoader();
        try {
            loader.setLocation(getClass().getResource("FXML.fxml"));
            root = loader.load();

        } catch (IOException ex) {
            Logger.getLogger(PhotoManager.class.getName()).log(Level.SEVERE, null, ex);
        }
        Scene scene = new Scene(root, 900, 600);
        FXMLController controllerFXML = loader.getController();
        controllerFXML.setMainController(controller);
        primaryStage.setTitle("PhotoEditor");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

}
