package edu.hw4;

import java.util.Comparator;
import java.util.List;

public class SortAnimalTasks {
    public static List<Animal> sortByHeightACS(List<Animal> animals) { // 1
        return animals.stream().
            sorted(Comparator.comparingInt(Animal::height)).toList();
    }

    public static List<Animal> sortByWeightDES(List<Animal> animals, int k) { // 2
        return animals.stream()
            .sorted(Comparator.comparingInt(Animal::weight).reversed())
            .limit(k).toList();
    }

    public static List<Animal> sortByTypeSexNameACS(List<Animal> animals) { // 16
        return animals.stream().
            sorted(Comparator.comparing(Animal::type)
                .thenComparing(Animal::sex)
                .thenComparing(Animal::name)).toList();
    }
}
