package org.stepik;

import java.io.*;
import java.sql.Time;

public class CloneTest {
    static class Person implements Serializable {
        String name;
        int age;
        Car car;

        Person(Car car, int age, String name) {
            this.car = car;
            this.age = age;
            this.name = name;
        }

        @Override
        public String toString() {
            return this.name + " {" +
                    "age=" + age +
                    ", car=" + car +
                    '}';
        }

        @Override
        protected Object clone() throws CloneNotSupportedException {
            return super.clone();
        }
    }

    static class Car implements Serializable {
        public String color;

        Car(String color) {
            this.color = color;
        }

        @Override
        public String toString() {
            return "{" +
                    "color car='" + color + '\'' +
                    '}';
        }
    }


    public static void main(String[] args) throws IOException, ClassNotFoundException {

        long nanoTime = System.nanoTime();

        Car car = new Car("Green");
        Person person = new Person(car, 25, "Mike");
        //Clone with Serialization
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(bos);
        objectOutputStream.writeObject(person);
        objectOutputStream.close();
        byte[] serializedPersontoByte = bos.toByteArray();
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(bos.toByteArray());
        Person clonePersone = null;
        //Serialize it
        ObjectInputStream ios = new ObjectInputStream(byteArrayInputStream);
        clonePersone = (Person) ios.readObject();
        byte[] byteArr = new byte[bos.toByteArray().length];
        byteArrayInputStream.read(byteArr);
        System.out.println(System.nanoTime() - nanoTime);

        System.out.println(person);
        System.out.println(clonePersone);
        System.out.println("Меняем клонов выводим");
        clonePersone.name = new String("Ivan");
        clonePersone.age = 18;
        clonePersone.car.color = "red";
        System.out.println(person);
        System.out.println(clonePersone);


    }
}