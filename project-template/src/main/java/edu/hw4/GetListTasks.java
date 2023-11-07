package edu.hw4;

import java.util.Arrays;
import java.util.List;

public class GetListTasks {

    public static List<Animal> getAgeNotEqualsPaws(List<Animal> animals) { // 10
        return animals.stream()
            .filter(animal -> animal.paws() != animal.age()).toList();
    }

    public static List<Animal> getBitingHigherThan100(List<Animal> animals) { // 11
        return animals.stream()
            .filter(animal -> animal.bites() && animal.height() > 100).toList();
    }

    public static List<Animal> getNotOneWordNameAnimals(List<Animal> animals) { // 13
        return animals.stream()
            .filter(animal -> Arrays.stream(animal.name()
                .split(" ")).toList().size() > 2).toList();
    }
}
