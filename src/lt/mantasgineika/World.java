package lt.mantasgineika;

import com.sun.tools.javac.jvm.Items;


import java.util.List;
import java.util.ArrayList;
import java.util.function.Predicate;

public class World {
    protected static int counter = 0;
    static int newHumans = 0;
    String[] namesFemale = {"Chloe", "Emma", "Olivia", "Jasmine", "Ava", "Melanie", "Naomi", "Grace", "Mia", "Jade", "Amber", "Zoe", "Abigail", "Danielle", "Lucy"};
    String[] namesMale = {"Jacob", "Shawn", "Ryan", "James", "Joseph", "Dylan", "Luke", "Chris", "Sam", "Harry", "Joel", "Joshua", "Xavier", "Liam", "Ethan"};

    public static int getCounter() {
        return counter;
    }

    public String randomNameFemale() {
        int randomNumber = namesFemale.length;
        int randomName = (int) (Math.random() * randomNumber);
        String randomNameFinal = namesFemale[randomName];
        return randomNameFinal;
    }

    public String randomNameMale() {
        int randomNumber = namesMale.length;
        int randomName = (int) (Math.random() * randomNumber);
        String randomNameFinal = namesMale[randomName];
        return randomNameFinal;
    }

}


