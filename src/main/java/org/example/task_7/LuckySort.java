package org.example.task_7;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class LuckySort {
    public static void luckySort(ArrayList<String> strings, Comparator<String> comp) {
        List<String> sortedCopy = new ArrayList<>(strings);

        sortedCopy.sort(comp);

        while (!strings.equals(sortedCopy)) {
            Collections.shuffle(strings);
        }
    }
}
