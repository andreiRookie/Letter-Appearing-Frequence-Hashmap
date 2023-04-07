import java.util.HashMap;
import java.util.Map;

public class TextAnalyzer {

    public Map<Character, Integer> getLettersAppearingMap(String text) {

        if (text.equals("")) {
            throw new IllegalArgumentException("Empty string");
        }

        Map<Character, Integer> map = new HashMap<>();
        Character character;
        String lowerText = text.toLowerCase();

        //            char[] symbols = TEXT.toCharArray();

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

    public Character getMostFrequentLetterAppearing(String text) {

        Map<Character, Integer> map = getLettersAppearingMap(text);

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

    public Character getLessFrequentLetterAppearing(String text) {

        Map<Character, Integer> map = getLettersAppearingMap(text);

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
