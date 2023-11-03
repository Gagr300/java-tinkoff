package edu.hw4;

import java.util.List;

public class BooleanTasks {
    public static boolean isDogHigherThan(List<Animal> animals, int k) { // 14
        return !animals.stream().filter(animal -> animal.height() > k).toList().isEmpty();
    }

    public static boolean isSpidersBitesMoreThanDogs(List<Animal> animals) { // 17
        return
            animals.stream().filter(animal ->
                animal.type() == Animal.Type.SPIDER && animal.bites()).toList().size() >
                animals.stream().filter(animal ->
                    animal.type() == Animal.Type.DOG && animal.bites()).toList().size();
    }
}
