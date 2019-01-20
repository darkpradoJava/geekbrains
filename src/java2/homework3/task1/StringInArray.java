package java2.homework3.task1;

import java.util.*;

/**
 * @author Stanislav Melekhin
 * Created on 20/01/2019
 */

public class StringInArray {

    private String[] array;
    private Set<String> set;
    private Map<String, Integer> map;

    public StringInArray() {
        array = new String[]{
                "a", "b", "c", "d", "e", "f", "g",
                "a", "b", "b", "h", "i", "f", "g",
                "b", "j", "k", "l", "m", "o", "o",
        };
    }

    @Override
    public String toString() {
        return Arrays.toString(array);
    }

    public void arrayToSet() {
        set = new HashSet<String>();
        for (String str : array) {
            set.add(str);
        }
    }

    public String toStringNoRepeat() {
        arrayToSet();
        return set.toString();
    }

    public void initMap() {
        map = new HashMap<String, Integer>();
        for (String s : set) {
            map.put(s, 0);
        }
    }

    public void fillMap() {
        for (String s : array) {
            map.put(s, (map.get(s)) + 1);
        }
    }

    public String repeatStringInArray() {
        initMap();
        fillMap();
        return map.toString();
    }

}

