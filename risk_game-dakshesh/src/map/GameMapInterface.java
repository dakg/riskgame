/*
This Interface contains the method that should be implemented in GameMap Class
Right now I(Dakshesh) had decided to put this many methods but it can decrease or
increase according to need.
*/

package map;
/**
 *
 * @author dakshesh
 */
public interface GameMapInterface {
    boolean verifyNumberOfContinents();
    boolean verifyNumberofCountries();
    boolean verifyNumberOfConnnections();
    boolean verifyMapFromFile(String fileLocation);
    boolean verifyMap();
}
