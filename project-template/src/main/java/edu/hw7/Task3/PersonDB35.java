package edu.hw7.Task3;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class PersonDB35 implements PersonDatabase {
    private final Map<Integer, Person> personsById = new HashMap<>();
    private final Map<String, List<Person>> personsByName = new HashMap<>();
    private final Map<String, List<Person>> personsByAddress = new HashMap<>();
    private final Map<String, Person> personsByPhone = new HashMap<>();

    private final ReadWriteLock lock = new ReentrantReadWriteLock();

    @Override
    public void add(Person person) {
        lock.writeLock().lock();
        try {
            personsById.put(person.id(), person);
            addToPersonByList(personsByName, person.name(), person);
            addToPersonByList(personsByAddress, person.address(), person);
            addToPersonBy(personsByPhone, person.phoneNumber(), person);
        } finally {
            lock.writeLock().unlock();
        }
    }

    @Override
    public void delete(int id) {
        lock.writeLock().lock();
        try {
            Person person = personsById.remove(id);
            deleteFromPersonsByList(personsByName, person.name());
            deleteFromPersonsByList(personsByAddress, person.address());
            deleteFromPersonsBy(personsByPhone, person.phoneNumber());
        } finally {
            lock.writeLock().unlock();
        }
    }

    @Override
    public List<Person> findByName(String name) {
        lock.readLock().lock();
        try {
            return personsByName.getOrDefault(name, null);
        } finally {
            lock.readLock().unlock();
        }
    }

    @Override
    public List<Person> findByAddress(String address) {
        lock.readLock().lock();
        try {
            return personsByAddress.getOrDefault(address, null);
        } finally {
            lock.readLock().unlock();
        }
    }

    @Override
    public Person findByPhone(String phone) {
        lock.readLock().lock();
        try {
            return personsByPhone.getOrDefault(phone, null);
        } finally {
            lock.readLock().unlock();
        }
    }

    private void deleteFromPersonsByList(Map<String, List<Person>> map, String key) {
        lock.writeLock().lock();
        try {
            map.remove(key);
        } finally {
            lock.writeLock().unlock();
        }
    }

    private void deleteFromPersonsBy(Map<String, Person> map, String key) {
        lock.writeLock().lock();
        try {
            map.remove(key);
        } finally {
            lock.writeLock().unlock();
        }
    }

    private void addToPersonByList(Map<String, List<Person>> map, String key, Person person) {
        lock.writeLock().lock();
        try {
            map.computeIfAbsent(key, mapper -> new ArrayList<>());
            map.get(key).add(person);
        } finally {
            lock.writeLock().unlock();
        }
    }

    private void addToPersonBy(Map<String, Person> map, String key, Person person) {
        lock.writeLock().lock();
        try {
            map.putIfAbsent(key, person);
        } finally {
            lock.writeLock().unlock();
        }
    }
}

