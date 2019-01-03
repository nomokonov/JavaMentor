package org.stepik.module_5;

import com.sun.org.apache.xml.internal.resolver.readers.ExtendedXMLCatalogReader;

import java.io.*;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Objects;

public class Test_5_4 {


    public static void main(String[] args) {
        System.out.println(Paths.get("."));
     Animal[] animals = {new Animal("A1"),new Animal("A2")};
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        try (ObjectOutputStream oos = new ObjectOutputStream(outputStream)) {
            try {
                    oos.writeInt(2);
                    oos.writeObject(animals[0]);
                    oos.writeObject(animals[1]);
                    oos.writeObject(new Double(0.1));

                } catch (Exception e) {
                e.printStackTrace();

            }
        } catch (IOException e){
            e.printStackTrace();
        }
        byte[] animalArr = outputStream.toByteArray();
        Animal[] animals1 = deserializeAnimalArray(animalArr);
        System.out.println(animals1[0].name);

    }

    public static Animal[] deserializeAnimalArray(byte[] data) {

        InputStream inputStream = new ByteArrayInputStream(data);
        Animal[] animals;
        try (ObjectInputStream ios = new ObjectInputStream(inputStream)) {
            int countAnimal = 0;
            countAnimal = ios.readInt();
            animals = new Animal[countAnimal];
            for (int i = 0; i < countAnimal; i++) {
                animals[i] = (Animal) ios.readObject();
            }
        } catch (IOException | ClassCastException | ClassNotFoundException e) {
            throw new IllegalArgumentException();
        }
        return animals;
    }


    static class Animal implements Serializable {
        private final String name;

        public Animal(String name) {
            this.name = name;
        }

        @Override
        public boolean equals(Object obj) {
            if (obj instanceof Animal) {
                return Objects.equals(name, ((Animal) obj).name);
            }
            return false;
        }
    }


}


class IllegalArgumentException extends RuntimeException {

}
