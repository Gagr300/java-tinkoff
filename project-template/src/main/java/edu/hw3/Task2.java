package edu.hw3;

import java.util.LinkedList;
import java.util.List;

public class Task2 {
    static public List<String> clusterize(String message) {
        List<String> clusters = new LinkedList<>();
        int opened = 0;
        int l = 0;
        for (int r = 0; r < message.length(); r++) {
            char c = message.charAt(r);
            if (c == '(') {
                opened++;
            } else if (c == ')') {
                if (opened > 0) {
                    opened--;
                }
                if (opened == 0) {
                    clusters.add(message.substring(l, r+1));
                    l = r + 1;
                }
                if (opened < 0){
                    clusters.clear();
                    return clusters;
                }
            } else {
                clusters.clear();
                return clusters;
            }
        }
        return clusters;
    }
}



