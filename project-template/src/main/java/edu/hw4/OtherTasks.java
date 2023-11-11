package edu.hw4;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.TreeSet;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.stream.Collectors;
import static java.util.Comparator.comparingInt;
import static java.util.stream.Collectors.groupingBy;
import static java.util.stream.Collectors.toCollection;

public class OtherTasks {

    public static Map<Animal.Type, Long> getCountByTypes(List<Animal> animals) { // 3
        return animals.stream().collect(groupingBy(
            Animal::type,
            Collectors.counting()
        ));
    }

    public static Animal.Sex getMostOftenSex(List<Animal> animals) { // 5
        int cntMales = (int) animals.stream()
            .filter(animal -> animal.sex() == Animal.Sex.M).count();
        return cntMales > animals.size() - cntMales ? Animal.Sex.M : Animal.Sex.F;
    }

    public static Map<Animal.Type, Animal> getHeaviest(List<Animal> animals) { // 6
        return animals.stream().collect(
            Collectors.toMap(Animal::type, Function.identity(),
            BinaryOperator.maxBy(Comparator.comparing(Animal::weight))));
    }

    public static int getNumberOfPaws(List<Animal> animals) { // 9
        return animals.stream()
            .mapToInt(Animal::paws).sum();
    }

    public static int getNumberWeightMoreThanHeight(List<Animal> animals) { // 12
        return animals.stream()
            .filter(animal -> animal.weight() > animal.height()).toList().size();
    }

    public static int getWeightSumAgeBetween(List<Animal> animals, int k, int l) { // 15
        return animals.stream()
            .filter(animal -> animal.age() >= k && animal.age() <= l)
            .mapToInt(Animal::weight).sum();
    }
}
