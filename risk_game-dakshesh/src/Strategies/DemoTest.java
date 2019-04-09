/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Strategies;

import java.util.stream.Collectors;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import static java.util.Map.Entry.comparingByValue;
import static java.util.stream.Collectors.*;
import static java.util.Map.Entry.*;
import java.util.Set;

/**
 *
 * @author daksh
 */
public class DemoTest {

    public static void main(String[] args) {
        HashMap<String, Integer> h = new HashMap();
        h.put("America", 5);
        h.put("Aadia", 6);
        h.put("China", 3);
        h.put("Aus", 1);
        h.put("Ira", 1);

        HashMap<String, Integer> h2 = new HashMap<>();
        h2.putAll(h);
        h2.remove("China");
        System.out.println(h);
        System.out.println("");
        System.out.println(h2);

        Map<String, Integer> sorted = h2
                .entrySet()
                .stream()
                .sorted(comparingByValue())
                .collect(
                        toMap(e -> e.getKey(), e -> e.getValue(), (e1, e2) -> e2,
                                LinkedHashMap::new));

        int sortedSize = sorted.size() / 2;
        Set entries = sorted.entrySet();
        Iterator it = entries.iterator();
        Map.Entry<String, Integer> pair = null;
        for (int i = 0; i < sortedSize; i++) {
            pair = (Map.Entry<String, Integer>) it.next();

        }
        String sourceCountry = pair.getKey();
        System.out.println("Source Country : " + sourceCountry);
        System.out.println("");
        System.out.println(sorted);

        Map.Entry<String, Integer> entry = Collections.max(sorted.entrySet(),
                Comparator.comparing(Map.Entry::getValue));

        String destinationCountry = entry.getKey();
        System.out.println("Source with min army : " + destinationCountry);

        //        Map.Entry<String, Integer> entry = Collections.min(h.entrySet(),
        //                Comparator.comparing(Map.Entry::getValue));
        //        String key = entry.getKey();
        //        System.out.println("Country min army : " + key);
        //        Map.Entry<String, Integer> entr = Collections.max(h.entrySet(),
        //                Comparator.comparing(Map.Entry::getValue));
        //        String ke = entr.getKey();
        //        System.out.println("Country max army : " + ke);
    }
}
