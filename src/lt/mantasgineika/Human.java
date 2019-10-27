package lt.mantasgineika;

import java.util.Random;

public class Human extends Items {

    public enum Gender {
        M, F;

        public static Gender getRandomGender() {
            Random random = new Random();
            return values()[random.nextInt(values().length)];
        }
    }

    int id;
    public int age;
    String name;
    Gender gender;

    {
        counter++;
    }

    Human(Gender gender, int age, int id) {
        this.gender = gender;
        this.age = age;
        this.id = id;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    @Override
    public String toString() {
        return "lt.mantasgineika.Human{" +
                "id=" + id +
                ", age=" + age +
                ", gender=" + gender +
                ", name=" + name +
                '}';
    }


}


