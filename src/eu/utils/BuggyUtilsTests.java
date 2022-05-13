package eu.utils;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Locale;
import java.util.Set;

import org.junit.Assert;
import org.junit.Test;

import eu.utils.BuggyUtils.KeyValue;
import eu.utils.BuggyUtils.Student;

/**
 * Tests that show that the class {@link BuggyUtils} is riddled with bugs.
 * <p>
 * This class should not be changed: Fix the bugs in {@link BuggyUtils} instead.
 * <p>
 * If all the unit tests pass, the tested methods are considered bug-free.
 * <p>
 * This class was tested with JRE 1.8.0_45
 *
 * @author Markus Weninger (markus.weninger@jku.at)
 *
 */
public class BuggyUtilsTests {
    private static final String GREEN_ENGLISH = "GREEN";
    private static final String GREEN_HEX = "#008000";
    private static final String WHITE_ENGLISH = "WHITE";
    private static final String WHITE_HEX = "#ffffff";

    /**
     * Tests the color conversion to hexadecimal for color "GREEN" with English
     * as the locale.
     */
    @Test
    public void colorConversionTestForGreenInEnglish() {
        final Locale oldLocale = Locale.getDefault();
        setLocaleToEnglish();
        final String expectedHex = GREEN_HEX;
        final String actualHex = BuggyUtils.colorNameToHex(GREEN_ENGLISH);

        // Reset the locale to the value it had when the test started
        Locale.setDefault(oldLocale);

        assertEquals("Conversion of " + GREEN_ENGLISH + " to " + expectedHex
                + " failed", expectedHex, actualHex);
    }

    /**
     * Tests the color conversion to hexadecimal for color "GREEN" with Turkish
     * as the locale.
     */
    @Test
    public void colorConversionTestForGreenInTurkish() {
        final Locale oldLocale = Locale.getDefault();
        setLocaleToTurkish();
        final String expectedHex = GREEN_HEX;
        final String actualHex = BuggyUtils.colorNameToHex(GREEN_ENGLISH);

        // Reset the locale to the value it had when the test started
        Locale.setDefault(oldLocale);

        assertEquals("Conversion of " + GREEN_ENGLISH + " to " + expectedHex
                + " failed", expectedHex, actualHex);
    }

    /**
     * Tests the color conversion to hexadecimal for color "WHITE" with English
     * as the locale.
     */
    @Test
    public void colorConversionTestForWhiteInEnglish() {
        final Locale oldLocale = Locale.getDefault();
        setLocaleToEnglish();
        final String expectedHex = WHITE_HEX;
        final String actualHex = BuggyUtils.colorNameToHex(WHITE_ENGLISH);

        // Reset the locale to the value it had when the test started
        Locale.setDefault(oldLocale);

        assertEquals("Conversion of " + WHITE_ENGLISH + " to " + expectedHex
                + " failed", expectedHex, actualHex);
    }

    /**
     * Tests the color conversion to hexadecimal for color "WHITE" with Turkish
     * as the locale.
     */
    @Test
    public void colorConversionTestForWhiteInTurkish() {
        final Locale oldLocale = Locale.getDefault();
        setLocaleToTurkish();
        final String expectedHex = WHITE_HEX;
        final String actualHex = BuggyUtils.colorNameToHex(WHITE_ENGLISH);

        // Reset the locale to the value it had when the test started
        Locale.setDefault(oldLocale);

        assertEquals("Conversion of " + WHITE_ENGLISH + " to " + expectedHex
                + " failed.", expectedHex, actualHex);
    }

    /**
     * Compares two equal lists containing integers ranging from 100 to 300.
     * It's expected that {@link BuggyUtils#areEqual(List, List)} returns true
     * for equal lists.
     */
    @Test
    public void equalityTestForEqualListsWithBigValues() {
        final List<Integer> firstList = Arrays.asList(100, 200, 300);
        final List<Integer> secondList = Arrays.asList(100, 200, 300);
        Assert.assertTrue("Lists with equal values should be equal.",
                BuggyUtils.areEqual(firstList, secondList));
    }

    /**
     * Compares two equal lists containing integers ranging from one to three.
     * It's expected that {@link BuggyUtils#areEqual(List, List)} returns true
     * for equal lists.
     * <p>
     * <b>Bonus</b>:
     * <p>
     * If you explain in your bug fix why this unit test succeeds with the buggy
     * version of {@link BuggyUtils#areEqual(List, List)} while
     * {@link #equalityTestForEqualListsWithBigValues()} fails, you get bonus
     * points.
     */
    @Test
    public void equalityTestForEqualListsWithSmallValues() {
        final List<Integer> firstList = Arrays.asList(1, 2, 3);
        final List<Integer> secondList = Arrays.asList(1, 2, 3);
        assertTrue("Lists with equal values should be equal.",
                BuggyUtils.areEqual(firstList, secondList));
    }

    /**
     * Creates a set of pairs consisting of a number (e.g., 1) and its spelled
     * out form in English (e.g., "one"). Checks that a pair which is equal to
     * one of the pairs in the set can be found in the set using
     * {@link Collection#contains(Object)}.
     */
    @Test
    public void findKeyValuePairInSet() {
        final Set<KeyValue<Integer, String>> pairs = new HashSet<>();
        pairs.add(new KeyValue<>(1, "one"));
        pairs.add(new KeyValue<>(2, "two"));
        pairs.add(new KeyValue<>(3, "three"));

        final KeyValue<Integer, String> findMe = new KeyValue<>(2, "two");
        Assert.assertTrue("This pair should be in the set: " + findMe,
                pairs.contains(findMe));
    }

    /**
     * Makes sure that a newly created {@link Student} is not null.
     */
    @Test
    public void newStudentIsNotNull() {
        final Student s = Student.create("Theresa Hollinger", 21, "123456789");
        Assert.assertNotNull("Newly created student should not be null.", s);
    }

    /**
     * Tests whether the rounding of a double to its first decimal place
     * succeeds.
     */
    @Test
    public void roundToFirstDecimalPlace() {

        final double roundMe = 1.46;
        final int decPlace = 1;
        final double output = BuggyUtils.round(roundMe, decPlace);
        final double expected = 1.5;
        assertEquals(expected, output, 0);
    }

    /**
     * Tests whether the rounding of a double to its second decimal place
     * succeeds.
     */
    @Test
    public void roundToSecondDecimalPlace() {

        final double roundMe = 1.005;
        final int decPlace = 2;
        final double output = BuggyUtils.round(roundMe, decPlace);
        final double expected = 1.01;
        assertEquals(expected, output, 0);
    }

    /**
     * Tests whether the rounding of a double to its third decimal place
     * succeeds.
     */
    @Test
    public void roundToThirdDecimalPlace() {

        final double roundMe = 123.0054;
        final int decPlace = 3;
        final double output = BuggyUtils.round(roundMe, decPlace);
        final double expected = 123.005;
        assertEquals(expected, output, 0);
    }

    /**
     * Makes sure that the result from {@link BuggyUtils#sum(double...)}, which
     * sums up some doubles, results in the expected {@link BigDecimal}.
     */
    @Test
    public void sumTest() {
        final double[] summands = { 1.1, 2.0, 1.0 };
        final BigDecimal expected = BigDecimal.valueOf(4.1);
        final BigDecimal actual = BuggyUtils.sum(summands);
        assertEquals(
                "Unexpected result of summing " + Arrays.toString(summands),
                expected, actual);
    }

    /**
     * Sets the locale to UK English.
     */
    private void setLocaleToEnglish() {
        Locale.setDefault(Locale.UK);
    }

    /**
     * Sets the locale to Turkish.
     */
    private void setLocaleToTurkish() {
        final String turkTag = "tr-TR";
        final Locale turkish = Locale.forLanguageTag(turkTag);
        Locale.setDefault(turkish);
    }
}