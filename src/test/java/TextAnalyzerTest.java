import org.junit.jupiter.api.*;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class TextAnalyzerTest {

    private final String TEXT = "Ut enim ad minim veniam.";
    private final Map<Character, Integer> EXPECTED = new HashMap<>() {
        {   put('a', 2);
            put('t', 1);
            put('d', 1);
            put('u', 1);
            put('e', 2);
            put('v', 1);
            put('i', 4);
            put('m', 4);
            put('n', 3);
        }};

    private final String EMPTY_TEXT = "";

    private static long suiteStartTime;
    private long testStartTime;

    @BeforeAll
    static void initSuite() {
        suiteStartTime = System.nanoTime();
        System.out.println("Testing started at "+ suiteStartTime);
    }

    @AfterAll
    static void completeSuite() {
        System.out.println("Testing completed at " +(System.nanoTime() - suiteStartTime));
    }

    @BeforeEach
    void startTest() {
        System.out.println("Starting the test..");
        testStartTime  = System.nanoTime();
    }

    @AfterEach
    void finalizeTest() {
        System.out.println("The test completed at " + (System.nanoTime() -testStartTime));
    }


    @Test
    void getLettersAppearingMap_test() {

        TextAnalyzer textAnalyzer = new TextAnalyzer();

        Map<Character, Integer> actual = textAnalyzer.getLettersAppearingMap(TEXT);

        assertEquals(EXPECTED, actual);
    }

    @Test
    void getLettersAppearingMap_notEverGreenTest() {
        TextAnalyzer textAnalyzer = new TextAnalyzer();

        Map<Character, Integer> expected = EXPECTED;
        expected.put('j',1);

        Map<Character, Integer> actual = textAnalyzer.getLettersAppearingMap(TEXT);

        assertEquals(expected, actual);
    }

    @Test
    void getLettersAppearingMap_shouldThrow() {
        TextAnalyzer textAnalyzer = new TextAnalyzer();
        assertThrows(IllegalArgumentException.class, () -> textAnalyzer.getLettersAppearingMap(EMPTY_TEXT));
    }

    @Test
    void getMostFrequentLetterAppearing_test() {
        TextAnalyzer textAnalyzer = new TextAnalyzer();
        Character expected = 'i';
        Character actual = textAnalyzer.getMostFrequentLetterAppearing(TEXT);
        assertEquals(expected, actual);
    }

    @Test
    void getMostFrequentLetterAppearing_notEverGreenTest() {
        TextAnalyzer textAnalyzer = new TextAnalyzer();
        Character expected = 'v';
        Character actual = textAnalyzer.getMostFrequentLetterAppearing(TEXT);
        assertEquals(expected, actual);
    }

    @Test
    void getMostFrequentLetterAppearing_shouldThrow() {
        TextAnalyzer textAnalyzer = new TextAnalyzer();
        assertThrows(IllegalArgumentException.class, () -> textAnalyzer.getMostFrequentLetterAppearing(EMPTY_TEXT));
    }

    @Test
    void getLessFrequentLetterAppearing_test() {
        TextAnalyzer textAnalyzer = new TextAnalyzer();
        Character expected = 't';
        Character actual = textAnalyzer.getLessFrequentLetterAppearing(TEXT);
        assertEquals(expected, actual);
    }

    @Test
    void getLessFrequentLetterAppearing_notEverGreenTest() {
        TextAnalyzer textAnalyzer = new TextAnalyzer();
        Character expected = 'd';
        Character actual = textAnalyzer.getLessFrequentLetterAppearing(TEXT);
        assertEquals(expected, actual);
    }

    @Test
    void getLessFrequentLetterAppearing_shouldThrow() {
        TextAnalyzer textAnalyzer = new TextAnalyzer();
        assertThrows(IllegalArgumentException.class, ()-> textAnalyzer.getMostFrequentLetterAppearing(EMPTY_TEXT));
    }

}