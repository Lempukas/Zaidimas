package lt.mantasgineika;

import java.util.ArrayList;
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
        for (int i = 0; i < 200; i++) {

            long humans20To40 = items.stream().filter(a -> a.getAge() >= 20 && a.getAge() <= 40).count();
            int newHumansCounter = 0;
            for (int randomBorn = 0; randomBorn < humans20To40 * 0.1; randomBorn++) {
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
                item.setAge(item.getAge() + 1);
            }

            System.out.println("Zmoniu tarp 20 ir 40 metu yra: " + humans20To40);
            System.out.println("Jie pagimde: " + newHumansCounter + " siemet.");
            System.out.println("Siemet mire " + skaiciuoti + " zmones.");
            System.out.println("----");

        }
        long isMale = items.stream().filter(a -> a.getGender() == Human.Gender.M).count();
        long isFemale = items.stream().filter(a -> a.getGender() == Human.Gender.F).count();

        System.out.println(" ");
        System.out.println("Ideta zmoniu is viso: " + World.getCounter());
        System.out.println(" ");
        System.out.println("Gyvu yra " + items.size() + " zmoniu.");
        System.out.println("Is ju " + isMale + " vyru.");
        System.out.println("Is ju " + isFemale + " moteru.");
        System.out.println(" ");
        System.out.println("Is viso mire : " + mirusiuSkaicius + " zmoniu.");
        System.out.println(" ");

    }
}
