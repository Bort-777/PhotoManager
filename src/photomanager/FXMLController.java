/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package photomanager;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.embed.swing.SwingFXUtils;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.image.ImageView;
import javafx.scene.image.WritableImage;
import javafx.stage.FileChooser;
import javax.imageio.ImageIO;
import photomanager.filtr.Constant;

/**
 * FXML Controller class
 *
 * @author Администратор
 */
public class FXMLController implements Initializable {

    
    @FXML
    private ImageView boxImage;
    @FXML
    private ImageView boxImage2;
    private Controller controller;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    public void setMainController(Controller control) {
        this.controller = control;
    }

    @FXML
    void connect() {
        

    }

    @FXML
    void open() {
        final FileChooser fileChooser = new FileChooser();
        File file = fileChooser.showOpenDialog(null);
        if (file != null) {
            BufferedImage bufferedImage = null;
            try {
                bufferedImage = ImageIO.read(file);
            } catch (IOException ex) {
                Logger.getLogger(FXMLController.class.getName()).log(Level.SEVERE, null, ex);
            }
            WritableImage image = SwingFXUtils.toFXImage(bufferedImage, null);
            boxImage.setImage(image);
            boxImage.setFitHeight(image.getHeight() / 2);
            boxImage.setFitWidth(image.getWidth() / 2);

            controller.setView(bufferedImage);            
        }

    }
    
    @FXML
    void filtrSepia() {
            WritableImage image;       
            BufferedImage tmpImage = controller.getNewImage(Constant.SEPIA);
            image = SwingFXUtils.toFXImage(tmpImage, null);
            boxImage2.setImage(image);
            boxImage2.setFitHeight(image.getHeight() / 2);
            boxImage2.setFitWidth(image.getWidth() / 2);
            
        }
 
    @FXML
    void filtrNegativ() {
            WritableImage image;       
            BufferedImage tmpImage = controller.getNewImage(Constant.NEGATIVE);
            image = SwingFXUtils.toFXImage(tmpImage, null);
            boxImage2.setImage(image);
            boxImage2.setFitHeight(image.getHeight() / 2);
            boxImage2.setFitWidth(image.getWidth() / 2);
            
        }
    
    }


