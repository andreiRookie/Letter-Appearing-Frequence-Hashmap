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

        TextAnalyzer textAnalyzer = new TextAnalyzer();

        Map<Character, Integer> map = textAnalyzer.getLettersAppearingMap(TEXT);
        System.out.println(map);
        System.out.println(textAnalyzer.getMostFrequentLetterAppearing(TEXT));
        System.out.println(textAnalyzer.getLessFrequentLetterAppearing(TEXT));

    }
}