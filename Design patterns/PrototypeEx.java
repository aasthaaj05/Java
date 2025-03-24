import java.util.HashMap;
import java.util.Map;

interface Prototype {
    Prototype clone();
}

class GameCharacter implements Prototype {
    private String name;
    private String type;

    public GameCharacter(String name, String type) {
        this.name = name;
        this.type = type;
    }

    @Override
    public Prototype clone() {
        return new GameCharacter(this.name, this.type); 
    }

    @Override
    public String toString() {
        return "GameCharacter{name='" + name + "', type='" + type + "'}";
    }
}

class PrototypeRegistry {
    private static Map<String, Prototype> prototypes = new HashMap<>();

    static {
        prototypes.put("Warrior", new GameCharacter("Default Warrior", "Warrior"));
        prototypes.put("Mage", new GameCharacter("Default Mage", "Mage"));
    }

    public static Prototype getPrototype(String type) {
        return prototypes.get(type).clone(); 
    }
}

public class PrototypeEx {
    public static void main(String[] args) {
        Prototype warrior = PrototypeRegistry.getPrototype("Warrior");
        Prototype mage = PrototypeRegistry.getPrototype("Mage");

        System.out.println(warrior);
        System.out.println(mage);
    }
}