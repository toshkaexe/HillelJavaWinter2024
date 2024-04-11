package org.hillel;

public class Main {
    public static void main(String[] args) {

        Person person1 = new Person("Peter", 30, "peter@gmail.com");
        Person person2 = new Person("Max", 40,"max@gmail.com");
        Person person3 = new Person("Alex", 50, "alex@gmail.com");

        Cache.put("cache1", "key1", person1);
        Cache.put("cache2", "key2", person2);
        Cache.put("cache3", "key3", person3);

        System.out.println(Cache.get("cache1", "key1"));

        System.out.println("Check if cache2 isCacheExist " + Cache.isCacheExist("cache2"));

        Cache.clear();

        System.out.println("Our cache is " +Cache.get("cache2", "key2") + " because is empty");
    }

}