import java.util.Random;
import java.util.stream.Stream;

public class Human extends Items {

    public enum Gender {
        M,F;
        public static Gender getRandomGender() {
            Random random = new Random();
            return values()[random.nextInt(values().length)];
        }
    }

    int id;
    public int age;
    String name;
    String[] namesFemale = {"Chloe", "Emma", "Olivia", "Jasmine", "Ava", "Melanie", "Naomi", "Grace", "Mia", "Jade", "Amber", "Zoe", "Abigail", "Danielle", "Lucy"};
    String[] namesMale = {"Jacob", "Shawn", "Ryan", "James", "Joseph", "Dylan", "Luke", "Chris", "Sam", "Harry", "Joel", "Joshua", "Xavier", "Liam", "Ethan"};
    Gender gender;


    {
        counter++;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    Human(Gender gender, int age, int id) {
        this.gender = gender;
        this.age = age;
        this.id = id;
    }

    @Override
    public String toString() {
        return "Human{" +
                "id=" + id +
                ", age=" + age +
                ", gender=" + gender +
                ", name=" + name +
                '}';
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


