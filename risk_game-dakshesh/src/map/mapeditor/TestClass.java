/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package map.mapeditor;
import models.GameMap;
import java.util.ArrayList;
import java.util.List;
import map.mapprocessor.InvalidMapException;
import map.mapprocessor.MapParser;
import map.mapprocessor.MapValidator;
/**
 *
 * @author daksh
 */
public class TestClass {
    public static void main(String[] args) throws InvalidMapException {
        
        EditMap e =new EditMap();
        e.loadMapFile("C:\\Users\\daksh\\Documents\\NetBeansProjects\\risk_game_28my\\risk_game-dakshesh\\.\\src\\Maps\\d.map");
    }

}
