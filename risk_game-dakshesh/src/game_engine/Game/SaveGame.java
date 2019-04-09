/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game_engine.Game;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

/**
 *
 * @author daksh
 */
public class SaveGame {

    GameObjectsWrapper gow;
    String location;

    public SaveGame(GameObjectsWrapper gow) {
        File currentDirectory = new File(new File(".").getAbsolutePath());
        String projectDirectory = currentDirectory.getAbsolutePath();
        location = projectDirectory + "//Saved Game//";
        this.gow = gow;
    }

    public int saveGame(String fileName) throws IOException {

        location = location + "//" + fileName + ".game";

        FileOutputStream fileOut = null;
        ObjectOutputStream objectOut = null;
        try {

            fileOut = new FileOutputStream(location);
            objectOut = new ObjectOutputStream(fileOut);
            objectOut.writeObject(gow);
            objectOut.close();
            System.out.println("The Object  was succesfully written to a file");

        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            if (fileOut != null) {
                fileOut.close();
            }
            if (objectOut != null) {
                objectOut.close();
            }
        }

        return 1;
    }
}
