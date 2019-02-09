/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Map;

/**
 *
 * @author daksh
 */
public interface GameMapInterface {
    boolean verifyNumberOfContinents();
    boolean verifyNumberofCountries();
    boolean verifyNumberOfConnnections();
    boolean verifyMapFromFile(String fileLocation);
    boolean verifyMap();
}
