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
import photomanager.segmentation.Segmentation;
import photomanager.staticEditor.PhotoChange;

/**
 *
 * @author Администратор
 */
public class Controller {

  
    private ViewControl view;
    private BufferedImage bufferedImage;
    private BufferedImage bufferedImageRight;
    private int num = 2;

    Controller() {
        
    }

    void setView(ViewControl view) {
        this.view = view;
        view.create(this);
    }

    void setView(BufferedImage bufferedImage) {
        this.bufferedImageRight = this.bufferedImage;
        this.bufferedImage = bufferedImage;
    }
    
    void setNum(int parseInt) {
        this.num = parseInt;
    }

    BufferedImage getNewImage(int filtr) {
        switch (filtr)
        {
            case 1 : return PhotoEdit.negativ(copy(bufferedImage));
            case 2 : return PhotoEdit.sepia(copy(bufferedImage));
            case 3 : return PhotoEdit.filtr3(copy(bufferedImage));
            case 4 : return PhotoEdit.made3d(copy(bufferedImage), copy(bufferedImageRight));
            case 5 : return PhotoChange.turn(copy(bufferedImage), num);
            case 6 : return (new Segmentation(copy(bufferedImage), num)).segmentCheck();
            case 7 : return PhotoChange.zoom(copy(bufferedImage), (double)num/1);
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
