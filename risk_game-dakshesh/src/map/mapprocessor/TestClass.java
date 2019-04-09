/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package map.mapprocessor;

/**
 *
 * @author daksh
 */
public class TestClass {

    public static void main(String[] args) throws InvalidMapException {
        //  MapParser.parseMap("C:\\Users\\daksh\\Desktop\\test_maps\\h.map");
       int a[][]= {
            {
                0 ,1 ,0 ,1 ,1 ,0 ,1 },
            {
                1 ,0 ,1 ,0 ,0 ,0 ,1 },
            {
                0 ,1 ,0 ,1 ,0 ,0 ,0 },
            {
                1 ,0 ,1 ,0 ,0 ,0 ,0 },
            {
                1 ,0 ,0 ,0 ,0 ,1 ,0 },
            {
                0 ,0 ,0 ,0 ,1 ,0 ,1 },
            {
                1 ,1 ,0 ,0 ,0 ,1 ,0 },
        };

        if (MapValidator.isGraphConnected(a)) {
            System.out.println("connected");
        } else {
            System.out.println("disconnected");
        }
    }
}
