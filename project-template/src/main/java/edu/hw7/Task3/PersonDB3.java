package edu.hw7.Task3;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PersonDB3 implements PersonDatabase {

    private final Map<Integer, Person> personsById = new HashMap<>();
    private final Map<String, List<Person>> personsByName = new HashMap<>();
    private final Map<String, List<Person>> personsByAddress = new HashMap<>();
    private final Map<String, Person> personsByPhone = new HashMap<>();

    @Override
    public synchronized void add(Person person) {
        personsById.put(person.id(), person);
        addToPersonByList(personsByName, person.name(), person);
        addToPersonByList(personsByAddress, person.address(), person);
        addToPersonBy(personsByPhone, person.phoneNumber(), person);
    }

    @Override
    public synchronized void delete(int id) {
        Person person = personsById.get(id);
        personsById.remove(id);
        deleteFromPersonsByList(personsByName, person.name());
        deleteFromPersonsByList(personsByAddress, person.address());
        deleteFromPersonsBy(personsByPhone, person.phoneNumber());
    }

    @Override
    public List<Person> findByName(String name) {
        return personsByName.get(name);
    }

    @Override
    public List<Person> findByAddress(String address) {
        return personsByAddress.get(address);
    }

    @Override
    public Person findByPhone(String phone) {
        return personsByPhone.get(phone);
    }

    private void deleteFromPersonsByList(Map<String, List<Person>> map, String key) {
        map.remove(key);
    }

    private void deleteFromPersonsBy(Map<String, Person> map, String key) {
        map.remove(key);
    }

    private void addToPersonByList(Map<String, List<Person>> map, String key, Person person) {
        map.computeIfAbsent(key, mapper -> new ArrayList<>());
        map.get(key).add(person);
    }

    private void addToPersonBy(Map<String, Person> map, String key, Person person) {
        map.putIfAbsent(key, person);
    }
}
