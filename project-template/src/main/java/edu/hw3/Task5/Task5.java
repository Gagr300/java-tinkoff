package edu.hw3.Task5;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import static edu.hw3.Task5.PhoneContact.ASC;
import static edu.hw3.Task5.PhoneContact.DES;

public class Task5 {

    public static List<PhoneContact> parseContacts(List<String> names, String srt) {
        List<PhoneContact> sortedNames = new LinkedList<>();
        for (String s : names) {
            String[] name = s.split(" ");
            if (name.length == 1) {
                sortedNames.add(new PhoneContact(name[0]));
            } else if (name.length == 2) {
                sortedNames.add(new PhoneContact(name[0], name[1]));
            } else {
                throw new IllegalArgumentException("Error! Illegal name \"" + s + "\"");
            }
        }
        if (srt.equalsIgnoreCase("asc")) {
            sortedNames.sort(ASC);
        } else if (srt.equalsIgnoreCase("desc")) {
            sortedNames.sort(DES);
        } else {
            throw new IllegalArgumentException("Error! Unknown sorting order");
        }
        return sortedNames;
    }

}
