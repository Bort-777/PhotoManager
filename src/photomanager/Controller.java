/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package photomanager;

import photomanager.staticEditor.PhotoEdit;
import java.awt.image.BufferedImage;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;

/**
 *
 * @author Администратор
 */
public class Controller {

  
    private ViewControl view;
    private BufferedImage bufferedImage;

    Controller() {
        
    }

    void setView(ViewControl view) {
        this.view = view;
        view.create(this);
    }

    void setView(BufferedImage bufferedImage) {
        this.bufferedImage = bufferedImage;
    }

    BufferedImage getNewImage(int filtr) {
        switch (filtr)
        {
            case 1 : return PhotoEdit.negativ(copy(bufferedImage));
            case 2 : return PhotoEdit.sepia(copy(bufferedImage));
            default: return bufferedImage;
        }   
    }
    
    BufferedImage copy(BufferedImage tmp) {
        return new BufferedImage(tmp.getColorModel(),
                tmp.copyData(null),
                tmp.isAlphaPremultiplied(),
                null);
    }
    
}
