package edu.hw4;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import static org.junit.jupiter.api.Assertions.assertEquals;
import java.util.Optional;
import java.util.Set;

public class Tests {

    Animal animal1 = new Animal("Stepan", Animal.Type.CAT, Animal.Sex.M,
        2, 20, 4, true
    );
    Animal animal2 = new Animal("Kot Cat Cat", Animal.Type.CAT, Animal.Sex.F,
        3, 25, 6, true
    );
    Animal animal3 = new Animal("Tolik", Animal.Type.SPIDER, Animal.Sex.M,
        1, 1, 0, false
    );
    Animal animal4 = new Animal("Dog Ovcharka Rex", Animal.Type.DOG, Animal.Sex.M,
        1, 200, 400, true
    );
    Animal animal5 = new Animal("", Animal.Type.FISH, Animal.Sex.M,
        0, 5, -1, false
    );
    Animal animal6 = new Animal("fish", Animal.Type.FISH, Animal.Sex.F,
        1, 10, 1, false
    );
    List<Animal> animalList = List.of(
        animal1, animal2, animal3,
        animal4, animal5, animal6
    );

    Animal animal7 = new Animal("golden fish", Animal.Type.FISH, Animal.Sex.M,
        10, 10, 10, true
    );
    List<Animal> animalList2 = List.of(animal7);

    @Test
    @DisplayName("task1")
    void task1() {
        var expectedResult = List.of(
            animal3, animal5, animal6,
            animal1, animal2, animal4
        );
        var actualResult = SortAnimalTasks.sortByHeightACS(animalList);
        assertEquals(expectedResult, actualResult);
    }

    @Test
    @DisplayName("task2")
    void task2() {
        var expectedResult = List.of(
            animal4, animal2, animal1
        );
        var actualResult = SortAnimalTasks.sortByWeightDES(animalList, 3);
        assertEquals(expectedResult, actualResult);
    }

    @Test
    @DisplayName("task3")
    void task3() {
        Map<Animal.Type, Long> expectedResult = new HashMap<Animal.Type, Long>() {{
            put(Animal.Type.CAT, 2L);
            put(Animal.Type.DOG, 1L);
            put(Animal.Type.SPIDER, 1L);
            put(Animal.Type.FISH, 2L);
        }};

        var actualResult = OtherTasks.getCountByTypes(animalList);
        assertEquals(expectedResult, actualResult);
    }

    @Test
    @DisplayName("task4")
    void task4() {
        var expectedResult = animal4;
        var actualResult = GetAnimalTasks.getLongestName(animalList);
        assertEquals(expectedResult, actualResult);
    }

    @Test
    @DisplayName("task5")
    void task5() {
        var expectedResult = Animal.Sex.M;
        var actualResult = OtherTasks.getMostOftenSex(animalList);
        assertEquals(expectedResult, actualResult);
    }

    @Test
    @DisplayName("task6")
    void task6() {
        Map<Animal.Type, Animal> expectedResult =
            new HashMap<Animal.Type, Animal>() {{
                put(Animal.Type.CAT, animal2);
                put(Animal.Type.DOG, animal4);
                put(Animal.Type.SPIDER, animal3);
                put(Animal.Type.FISH, animal6);
            }};
        var actualResult = OtherTasks.getHeaviest(animalList);
        assertEquals(expectedResult, actualResult);
    }

    @Test
    @DisplayName("task7")
    void task7() {
        var expectedResult = animal1;
        var actualResult = GetAnimalTasks.getOldest(animalList, 2);
        assertEquals(expectedResult, actualResult);
    }

    @Test
    @DisplayName("task8")
    void task8() {
        var expectedResult = animal1;
        var actualResult = GetAnimalTasks.getHeaviestLowerThan(animalList, 25);
        assertEquals(expectedResult, actualResult);
    }

    @Test
    @DisplayName("task9")
    void task9() {
        var expectedResult = 20;
        var actualResult = OtherTasks.getNumberOfPaws(animalList);
        assertEquals(expectedResult, actualResult);
    }

    @Test
    @DisplayName("task10")
    void task10() {
        var expectedResult = List.of(
            animal1, animal2, animal3,
            animal4, animal6
        );
        var actualResult = GetListTasks.getAgeNotEqualsPaws(animalList);
        assertEquals(expectedResult, actualResult);
    }

    @Test
    @DisplayName("task11")
    void task11() {
        var expectedResult = List.of(animal4);
        var actualResult = GetListTasks.getBitingHigherThan100(animalList);
        assertEquals(expectedResult, actualResult);
    }

    @Test
    @DisplayName("task12")
    void task12() {
        var expectedResult = 1;
        var actualResult = OtherTasks.getNumberWeightMoreThanHeight(animalList);
        assertEquals(expectedResult, actualResult);
    }

    @Test
    @DisplayName("task13")
    void task13() {
        var expectedResult = List.of(animal2, animal4);
        var actualResult = GetListTasks.getNotOneWordNameAnimals(animalList);
        assertEquals(expectedResult, actualResult);
    }

    @Test
    @DisplayName("task14t")
    void task14t() {
        var expectedResult = false;
        var actualResult = BooleanTasks.isDogHigherThan(animalList, 300);
        assertEquals(expectedResult, actualResult);
    }

    @Test
    @DisplayName("task14f")
    void task14f() {
        var expectedResult = true;
        var actualResult = BooleanTasks.isDogHigherThan(animalList, 100);
        assertEquals(expectedResult, actualResult);
    }

    @Test
    @DisplayName("task15")
    void task15() {
        var expectedResult = 400;
        var actualResult = OtherTasks.getWeightSumAgeBetween(animalList, 0, 1);
        assertEquals(expectedResult, actualResult);
    }

    @Test
    @DisplayName("task16")
    void task16() {
        var expectedResult = List.of(
            animal1, animal2, animal4,
            animal5, animal6, animal3
        );
        var actualResult = SortAnimalTasks.sortByTypeSexNameACS(animalList);
        assertEquals(expectedResult, actualResult);
    }

    @Test
    @DisplayName("task17")
    void task17() {
        var expectedResult = false;
        var actualResult = BooleanTasks.isSpidersBitesMoreThanDogs(animalList);
        assertEquals(expectedResult, actualResult);
    }

    @Test
    @DisplayName("task18")
    void task18() {
        var expectedResult = animal7;
        var actualResult = GetAnimalTasks.getHeaviestAFish(animalList, animalList2);
        assertEquals(expectedResult, actualResult);
    }

    @Test
    @DisplayName("task19")
    void task19() {
        Tasks1920 task = new Tasks1920();
        Map<String, Set<ValidationError>> expectedResult = new HashMap<>() {{
            put("Tolik", Set.of());
            put("Kot Cat Cat", Set.of());
            put("fish", Set.of());
            put("Dog Ovcharka Rex", Set.of());
            put("Stepan", Set.of());
            put("", Set.of(
                new ValidationError(
                    "Too short name.",
                    ValidationError.ErrorType.NAME
                ),
                new ValidationError(
                    "Weight must be a non-negative integer.",
                    ValidationError.ErrorType.WEIGHT
                )
            ));
        }};
        var actualResult = task.getMistakes(animalList);
        assertEquals(expectedResult, actualResult);
    }

    @Test
    @DisplayName("task20")
    void task20() {
        Tasks1920 task = new Tasks1920();
        Map<String, String> expectedResult = new HashMap<>() {{
            put("Tolik", "");
            put("Kot Cat Cat", "");
            put("fish", "");
            put("Dog Ovcharka Rex", "");
            put("Stepan", "");
            put("", "WEIGHT: Weight must be a non-negative integer.|NAME: Too short name.");
        }};
        System.out.println(task.validateAnimalInfo(animal5));
        var actualResult = task.getMistakesInfo(animalList);
        assertEquals(expectedResult, actualResult);
    }
}
