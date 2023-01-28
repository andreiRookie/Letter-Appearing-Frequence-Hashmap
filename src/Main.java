import java.util.HashMap;
import java.util.Map;

public class Main {

    static final String TEXT = """
            Lorem ipsum dolor sit amet, consectetur adipiscing elit, 
            sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. 
            Ut enim ad minim veniam, quis nostrud exercitation ullamco 
            laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure 
            dolor in reprehenderit in voluptate velit esse cillum dolore eu 
            fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, 
            sunt in culpa qui officia deserunt mollit anim id est laborum.""";

    public static void main(String[] args) {

        Map<Character, Integer> map = getLettersAppearingMap(TEXT);
        System.out.println(map);
        System.out.println(getMostFrequentLetterAppearing(map));
        System.out.println(getLessFrequentLetterAppearing(map));

    }

    static Map<Character, Integer> getLettersAppearingMap(String text) {

        Map<Character, Integer> map = new HashMap<>();
        Character character;
        String lowerText = text.toLowerCase();

        for (int i = 0; i < lowerText.length(); i++) {

            character = lowerText.charAt(i);

            if (Character.isLetter(character)) {
                if (map.containsKey(character)) {
                    Integer count = map.get(character);
                    map.put(character, count + 1);
                } else {
                    map.put(character, 1);
                }
            }
        }
        return map;
    }

    static Character getMostFrequentLetterAppearing(Map<Character, Integer> map) {

        Character mostFreqChar = null;
        Integer freq = -1;

        for (Map.Entry<Character, Integer> entry : map.entrySet()) {
            if (entry.getValue() > freq) {
                freq = entry.getValue();
                mostFreqChar = entry.getKey();
            }
        }
        return mostFreqChar;
    }

    static Character getLessFrequentLetterAppearing(Map<Character, Integer> map) {
        Character lessFreqChar = null;
        Integer freq = Integer.MAX_VALUE;

        for (Map.Entry<Character, Integer> entry : map.entrySet()) {
            if (entry.getValue() < freq) {
                freq = entry.getValue();
                lessFreqChar = entry.getKey();
            }
        }
        return lessFreqChar;
    }
}