/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Map;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;

class Position {

    int x;
    int y;

    Position() {
        x = 0;
        y = 0;
    }

    Position(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

class MapObject {

    HashMap worldMap;
    HashMap continentValue;

    String author;
    String scroll;
    String image;
    boolean wrap;
    boolean warn;

    int numberOfContinents;
    int numberOfCountries;

    ArrayList nameOfContinents;
    ArrayList nameOfCountries;

    HashMap countryPosition;

    int worldAdjacencyMatrix[][];

    HashMap continentMatrices;

    MapObject() {
        nameOfContinents = new ArrayList();
        nameOfCountries = new ArrayList();
        countryPosition = new HashMap<String, Position>();
        continentMatrices = new HashMap<String, int[][]>();
    }

    MapObject(HashMap worldMap, HashMap continentValue) {
        this();
        this.worldMap = worldMap;
        this.continentValue = continentValue;
        fillNumberOfContinents(worldMap);
        fillNumberOfCountries(worldMap);

        fillNameOfContinents(worldMap);
        fillNameOfCountries(worldMap);

        fillWorldAdjacencyMatrix(worldMap);
        fillContinentsMatrices(worldMap);

        fillCountryPosition(worldMap);                                          //irrelevant but we will store information for future use

    }

//    MapObject(File mapLocation) {
//        this();
//        HashMap worldMap;                                                        //Get worldMap from file
//        HashMap continentValue;                                                  //Get continentValue from file
//        
//    }

    void fillNumberOfContinents(HashMap worldMap) {

    }

    void fillNumberOfCountries(HashMap worldMap) {

    }

    void fillNameOfContinents(HashMap worldMap) {

    }

    void fillNameOfCountries(HashMap worldMap) {

    }

    void fillWorldAdjacencyMatrix(HashMap worldMap) {

    }

    void fillContinentsMatrices(HashMap worldMap) {

    }

    void fillCountryPosition(HashMap worldMap) {

    }

}
