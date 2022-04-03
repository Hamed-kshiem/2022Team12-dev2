package eu.conflicts;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

/**
 * Tests the methods in {@link Conflicts} and defines their expected behavior.
 *
 * @author Markus Weninger (markus.weninger@jku.at)
 *
 */
public class ConflictsTests {

    /**
     * Capture the contents of System.out
     */
    private final ByteArrayOutputStream sysOutContent = new ByteArrayOutputStream();

    @Test
    public void eratosthenes() {
        final int upperBound = 10;
        final List<Integer> expectedOutput = Arrays.asList(2, 3, 5, 7);
        final List<Integer> output = Conflicts.eratosthenes(upperBound);
        assertEquals(expectedOutput, output);
    }

    @Test
    public void fibonacciProds() {
        // Fibonacci sequence is 1, 2, 3, 5, 8, 13
        final int upperBound = 13;
        final int expectedOutput = 3120;
        final int output = Conflicts.fibonacciProd(upperBound);
        assertEquals(expectedOutput, output);
    }

    @Test
    public void fizzBuzz() {
        final String ls = System.lineSeparator();
        final String expectedOutput = "1" + ls + "2" + ls + "Fizz" + ls + "4"
                + ls + "Buzz" + ls + "Fizz" + ls + "7" + ls + "8" + ls + "Fizz"
                + ls + "Buzz" + ls + "11" + ls + "Fizz" + ls + "13" + ls + "14"
                + ls + "FizzBuzz" + ls + "16" + ls;

        final int upperBound = 16;
        Conflicts.fizzBuzz(upperBound);
        assertEquals(expectedOutput, sysOutContent.toString());
    }

    @Test
    public void getAlphabet() {

        final List<Character> expectedOutput = Arrays.asList('A', 'B', 'C',
                'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O',
                'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z');
        final List<Character> output = Conflicts.getAlphabet();
        assertEquals(expectedOutput, output);
    }

    @Test
    public void getInts1() {
        final String input = "There are 25 students in this room. I see that 2, no, 3 of them are new.";
        final List<Integer> expectedOutput = Arrays.asList(25, 2, 3);
        final List<Integer> output = Conflicts.getInts(input);
        assertEquals(expectedOutput, output);
    }

    @Test
    public void getInts2() {
        final String input = "When I was 4 years old, I thought people would live to the age of 400.";
        final List<Integer> expectedOutput = Arrays.asList(4, 400);
        final List<Integer> output = Conflicts.getInts(input);
        assertEquals(expectedOutput, output);
    }

    @Test
    public void getInts3() {
        final String input = "There are twenty-five students in this room. I see that two, no, three of them are new.";
        final List<Integer> expectedOutput = new ArrayList<>();
        final List<Integer> output = Conflicts.getInts(input);
        assertEquals(expectedOutput, output);
    }

    @Test
    public void isPalindrome1() {
        final String input = "tattarrattat";
        final boolean output = Conflicts.isPalindrome(input);

        assertTrue(output);
    }

    @Test
    public void isPalindrome2() {
        final String input = "Reliefpfeiler";
        final boolean output = Conflicts.isPalindrome(input);

        assertTrue(output);
    }

    @Test
    public void isPalindrome3() {
        final String input = "palindrome";
        final boolean output = Conflicts.isPalindrome(input);

        assertFalse(output);
    }

    @Before
    public void setUpSysOutStream() {
        System.setOut(new PrintStream(sysOutContent));
    }
}