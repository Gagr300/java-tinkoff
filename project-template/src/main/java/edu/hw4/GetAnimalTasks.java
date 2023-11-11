package edu.hw4;

import java.util.Arrays;
import java.util.Collection;
import java.util.Comparator;
import java.util.List;

public class GetAnimalTasks {

    public static Animal getLongestName(List<Animal> animals) { // 4
        return animals.stream()
            .max(Comparator.comparingInt(animal -> animal.name().length()))
            .orElseThrow();
    }

    public static Animal getOldest(List<Animal> animals, int k) { // 7
        if (animals.size() < k) {
            return null;
        }
        return animals.stream()
            .sorted(Comparator.comparingInt(Animal::age).reversed()).toList()
            .get(k - 1);
    }

    public static Animal getHeaviestLowerThan(List<Animal> animals, int k) { // 8
        return animals.stream()
            .filter(animal -> animal.height() < k)
            .max(Comparator.comparingInt(Animal::weight))
            .orElseThrow();
    }

    public static Animal getHeaviestAFish(List<Animal>... animals) { // 18
        return Arrays.stream(animals).flatMap(Collection::stream)
            .filter(animal -> animal.type() == Animal.Type.FISH)
            .max(Comparator.comparingInt(Animal::weight))
            .orElseThrow();
    }
}
