package edu.hw7;

import edu.hw7.Task3.Person;
import edu.hw7.Task3.PersonDB3;
import edu.hw7.Task3.PersonDB35;
import org.junit.jupiter.api.Test;
import java.util.List;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class Tests3 {
    Person person1 = new Person(1, "Nick", "address1", "000000001");
    Person person2 = new Person(2, "Rick", "address2", "000000002");
    Person person3 = new Person(3, "Kate", "address3", "000000003");

    @Test
    public void testName() {
        PersonDB3 database = new PersonDB3();
        database.add(person1);
        database.add(person2);
        database.add(person3);
        assertEquals(List.of(person1), database.findByName("Nick"));
    }

    @Test
    public void testPhone() {
        PersonDB3 database = new PersonDB3();
        database.add(person1);
        database.add(person2);
        database.add(person3);
        database.delete(2);
        assertNull(database.findByPhone("000000002"));
    }

    @Test
    public void testConcurrent() throws InterruptedException {
        PersonDB3 database = new PersonDB3();

        Thread addThread = new Thread(() -> {
            int id = 1;
            Person person = new Person(
                id,
                "name" + id,
                "address" + id,
                "000000" + id
            );
            database.add(person);
        });

        Thread findThread = new Thread(() -> {
            int id = 1;
            String name = "name" + id;
            String address = "address" + id;
            String phone = "000000" + id;

            Person phonePerson = database.findByPhone(phone);
            List<Person> namePerson = database.findByName(name);
            List<Person> addressPerson = database.findByAddress(address);

            boolean result = false;
            if (phonePerson != null) {
                if (!namePerson.isEmpty() && !addressPerson.isEmpty() &&
                    namePerson.contains(phonePerson) && addressPerson.contains(phonePerson)) {
                    result = true;
                }
            } else {
                result = true;
            }
            assertTrue(result);
        });

        addThread.start();
        findThread.start();

        addThread.join();
        findThread.join();
    }

    @Test
    public void testName35() {
        PersonDB35 database = new PersonDB35();
        database.add(person1);
        database.add(person2);
        database.add(person3);
        assertEquals(List.of(person1), database.findByName("Nick"));
    }

    @Test
    public void testPhone35() {
        PersonDB35 database = new PersonDB35();
        database.add(person1);
        database.add(person2);
        database.add(person3);
        database.delete(2);
        assertNull(database.findByPhone("000000002"));
    }

    @Test
    public void testConcurrent35() throws InterruptedException {
        PersonDB35 database = new PersonDB35();

        Thread addThread = new Thread(() -> {
            int id = 1;
            Person person = new Person(
                id,
                "name" + id,
                "address" + id,
                "000000" + id
            );
            database.add(person);
        });

        Thread findThread = new Thread(() -> {
            int id = 1;
            String name = "name" + id;
            String address = "address" + id;
            String phone = "000000" + id;

            Person phonePerson = database.findByPhone(phone);
            List<Person> namePerson = database.findByName(name);
            List<Person> addressPerson = database.findByAddress(address);

            boolean result = false;
            if (phonePerson != null) {
                if (!namePerson.isEmpty() && !addressPerson.isEmpty() &&
                    namePerson.contains(phonePerson) && addressPerson.contains(phonePerson)) {
                    result = true;
                }
            } else {
                result = true;
            }
            assertTrue(result);
        });

        addThread.start();
        findThread.start();

        addThread.join();
        findThread.join();
    }

}
