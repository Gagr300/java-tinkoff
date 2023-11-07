package edu.hw4;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class Tasks1920 {

    public Map<String, Set<ValidationError>> getMistakes(List<Animal> animals) { // 19
        return animals.stream()
            .collect(Collectors.toMap(
                Animal::name,
                this::validateAnimal
            ));
    }

    public Map<String, String> getMistakesInfo(List<Animal> animals) { // 19
        return animals.stream()
            .collect(Collectors.toMap(
                Animal::name,
                this::validateAnimalInfo
            ));
    }

    public Set<ValidationError> validateAnimal(Animal animal) {
        Set<ValidationError> errors = new HashSet<>();
        if (animal.age() < 0) {
            errors.add(new ValidationError(
                "Age must be a non-negative integer.",
                ValidationError.ErrorType.AGE
            ));
        }
        if (animal.height() < 0) {
            errors.add(new ValidationError(
                "Height must be a non-negative integer.",
                ValidationError.ErrorType.HEIGHT
            ));
        }
        if (animal.weight() < 0) {
            errors.add(new ValidationError(
                "Weight must be a non-negative integer.",
                ValidationError.ErrorType.WEIGHT
            ));
        }
        if (animal.weight() < 0) {
            errors.add(new ValidationError(
                "Weight must be a non-negative integer.",
                ValidationError.ErrorType.WEIGHT
            ));
        }
        if (animal.name().length() < 2) {
            errors.add(new ValidationError(
                "Too short name.",
                ValidationError.ErrorType.NAME
            ));
        }
        if (animal.type() == null) {
            errors.add(new ValidationError(
                "Any animal must have type.",
                ValidationError.ErrorType.TYPE
            ));
        }
        return errors;
    }

    public String validateAnimalInfo(Animal animal) {
        Set<ValidationError> errors = validateAnimal(animal);
        List<String> errorMessages = new ArrayList<>();
        for (var e : errors) {
            errorMessages.add(e.toString());
        }
        return String.join("|", errorMessages);
    }

}
