package lt.mantasgineika;

public class NonHuman extends World {
    String type;
    String name;


    NonHuman(String type, String name) {
        this.type = type;
        this.name = name;
        counter++;
    }
}