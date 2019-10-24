
import sun.security.krb5.internal.crypto.HmacMd5ArcFourCksumType;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.function.Predicate;


public class Main {
    public static void main(String[] args) {
        long mirusiuSkaicius = 0;
        List<Human> items = new ArrayList<>(1000);
        // Pradiniai zmones su random amziumi ir lytimi ir random vardu pagal lyti
        for (int i = 1; i <= 10; i++) {
            int randomN = (int) (Math.random() * 80) + 1;
            Human human = new Human(Human.Gender.getRandomGender(), randomN, i);
            if (human.gender == Human.Gender.F) {
                human.name = human.randomNameFemale();
            } else {
                human.name = human.randomNameMale();
            }
            items.add(human);
        }

        //Metu loopas
        for (int i = 0; i < 10; i++) {

            long humans20To50 = items.stream().filter(a -> a.getAge() >= 20 && a.getAge() <= 40).count();
            int newHumansCounter = 0;
            for (int randomBorn = 0; randomBorn < humans20To50 * 0.1; randomBorn++) {
                int id = World.getCounter() + 1;
                Human human = new Human(Human.Gender.getRandomGender(), 0, id);
                if (human.gender == Human.Gender.F) {
                    human.name = human.randomNameFemale();
                } else {
                    human.name = human.randomNameMale();
                }
                items.add(human);
                newHumansCounter++;
            }

            //Zmoniu mirimas pasiekus 100 metu ir suskaiciavimas
            Predicate<Human> ismetimas = items1 -> items1.getAge() >= 80;
            long skaiciuoti = items.stream().filter(a -> a.getAge() >= 80).count();
            mirusiuSkaicius += skaiciuoti;
            items.removeIf(ismetimas);

            for (Human item : items) {
                System.out.println(item);
                item.setAge(item.getAge() + 1);
            }

            System.out.println(" ");
            System.out.println("Ideta zmoniu is viso: " + World.getCounter());
            System.out.println(" ");
            System.out.println("Dabar yra " + items.size() + " zmoniu.");
            System.out.println(" ");
            System.out.println("Is viso mire : " + mirusiuSkaicius + " zmoniu.");
            System.out.println(" ");
            System.out.println("Zmoniu tarp 20 ir 40 metu yra: " + humans20To50);
            System.out.println(" ");
            System.out.println("Jie pagimde: " + newHumansCounter + " siemet.");
        }
    }
}
