import java.util.HashMap;
import java.util.Map;

interface Character {
    void display(int position);
}

class ConcreteCharacter implements Character {
    private char symbol;

    public ConcreteCharacter(char symbol) {
        this.symbol = symbol;
    }

    @Override
    public void display(int position) {
        System.out.println("Character '" + symbol + "' at position " + position);
    }
}

class CharacterFactory {
    private static Map<Character, Character> characters = new HashMap<>();

    public static Character getCharacter(char symbol) {
        if (!characters.containsKey(symbol)) {
            characters.put(symbol, new ConcreteCharacter(symbol)); 
        }
        return characters.get(symbol);
    }
}

public class FlyWeight {
    public static void main(String[] args) {
        String text = "HELLO";

        for (int i = 0; i < text.length(); i++) {
            char symbol = text.charAt(i);
            Character character = CharacterFactory.getCharacter(symbol);
            character.display(i);
        }
    }
}