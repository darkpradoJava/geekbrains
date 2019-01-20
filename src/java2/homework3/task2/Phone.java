package java2.homework3.task2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Stanislav Melekhin
 * Created on 20/01/2019
 */

public class Phone {

    private Map<String, ArrayList<Integer>> phone;

    public Phone() {
        phone = new HashMap<String, ArrayList<Integer>>();
    }

    public void add(String s, int... num) {
        ArrayList<Integer> tel = new ArrayList<Integer>();
        if (phone.containsKey(s)) {
            tel = phone.get(s);
        }
        for (int n : num) {
            tel.add(n);
        }
        phone.put(s, tel);
    }

    public void print() {
        phone.forEach((k, v) -> {
            System.out.print(k + ": ");
            for (int n : v) {
                System.out.print(n + " ");
            }
            System.out.println();
        });
    }

    public void getPhone(String s) {
        ArrayList<Integer> a = new ArrayList<Integer>();
        System.out.print(s + ": ");
        for (int n : phone.get(s)) {
            System.out.print(n + " ");
        }
        System.out.println();
    }

}
