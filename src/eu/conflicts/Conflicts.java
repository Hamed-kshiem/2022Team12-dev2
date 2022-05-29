package eu.conflicts;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

/**
 * Implement these methods together with a partner. Use Git to commit your code.
 * Create and resolve at least one conflict with your partner. Use Gerrit to
 * review the commits.
 * <p>
 * Refer to {@link ConflictsTests} for the expected behavior of each method. If
 * all unit tests pass, the methods are considered successfully implemented.
 *
 * @author Markus Weninger (markus.weninger@jku.at)
 */
public class Conflicts {

    /**
     * Calculates the <a
     * href="https://en.wikipedia.org/wiki/Sieve_of_Eratosthenes">Sieve of
     * Eratosthenes</a> from two to {@code upperBound} inclusive.
     */
    public static List<Integer> eratosthenes(final int upperBound) {
        if (upperBound < 2) {
            throw new IllegalArgumentException("upperBound must be greater than 1");
        }
        final List<Integer> primes = new ArrayList<>();
        final boolean[] isPrime = new boolean[upperBound + 1];
        for (int i = 2; i <= upperBound; i++) {
            isPrime[i] = true;
        }
        for (int i = 2; i <= upperBound; i++) {
            if (isPrime[i]) {
                primes.add(i);
                for (int j = i * i; j <= upperBound; j += i) {
                    isPrime[j] = false;
                }
            }
        }
        return primes;
    }

    /**
     * Calculates the product of the Fibonacci sequence from 1 to
     * {@code upperBound} inclusive.
     */
    public static int fibonacciProd(final int upperBound) {
        if (upperBound < 2) {
            throw new IllegalArgumentException("upperBound must be greater than 1");
        }
        int a = 0;
        int b = 1;
        int c = a + b;
        int prod = 1;
        while (c <= upperBound) {
            prod *= c;
            a = b;
            b = c;
            c = a + b;
        }
        return prod;
    }

    /**
     * Prints the numbers from 1 to {@code upperBound} inclusive to
     * {@link System#out}. For multiples of three prints "Fizz" instead of the
     * number and for multiples of five prints "Buzz". For numbers which are
     * multiples of both three and five prints "FizzBuzz".
     */
    public static void fizzBuzz(final int upperBound) {
        if (upperBound < 2) {
            throw new IllegalArgumentException("upperBound must be greater than 1");
        }
        for (int i = 1; i <= upperBound; i++) {
               if (i % 3 == 0 && i % 5 == 0) {
                    System.out.println("FizzBuzz");
                } else if (i % 3 == 0) {
                    System.out.println("Fizz");
                } else if (i % 5 == 0) {
                    System.out.println("Buzz");
                } else {
                    System.out.println(i);
                }
        }
    }

    /**
     * Gets the 26 uppercase characters from {@code A} to {@code Z}.
     *
     * @return the English uppercase alphabet as a {@link List} of
     * {@link Character}s
     */
    public static List<Character> getAlphabet() {
        final List<Character> alphabet = new ArrayList<>(28);
        for (char c = 'A'; c <= 'Z'; c++) {
            alphabet.add(c);
        }
        return alphabet;
    }

    /**
     * Gets all the integers from a {@code string}.
     *
     * @param string that might contain integers
     * @return all the integers inside the {@code string}
     */
    public static List<Integer> getInts(final String string) {
        final List<Integer> ints = new ArrayList<>();

        if(string == null) {
           return ints;
        }
        String result = string.replaceAll("[^0-9]+", " ");
        String[] numbers = result.split(" ");
        for (String number : numbers) {
            if (!number.isEmpty()) {
                ints.add(Integer.parseInt(number));
            }
        }
        return ints;
    }

    /**
     * Determines whether a {@code string} is equal to itself when reversed.
     * Case insensitive.
     *
     * @param string which may be a palindrome
     * @return whether the {@code string} is a palindrome
     */
    public static boolean isPalindrome(final String string) {
        if (string == null) {
            throw new IllegalArgumentException("string must not be null");
        }
        final StringBuilder sb = new StringBuilder(string);
        return sb.reverse().toString().equalsIgnoreCase(string);
    }
}