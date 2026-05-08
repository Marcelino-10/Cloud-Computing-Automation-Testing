package Tests;

import org.example.Services.DigitScrubber;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class DigitScrubberTest {

    //testing numbers and letters
    @Test
    public void ScrubberDigit1() {

        DigitScrubber scrubber = new DigitScrubber();
        String input = "Call me at 12345";
        String result = scrubber.scrub(input);
        assertEquals("Call me at XXXXX", result);

    }

    //testing no digits
    @Test
    public void ScrubberDigit3() {

        DigitScrubber scrubber = new DigitScrubber();
        String input = "No digits here";
        String result = scrubber.scrub(input);
        assertEquals("No digits here", result);

    }

    //testing null
    @Test(expected = NullPointerException.class)
    public void ScrubberDigit4() {

        DigitScrubber scrubber = new DigitScrubber();
        scrubber.scrub(null);

    }

    //testing blank
    @Test(expected = IllegalArgumentException.class)
    public void ScrubberDigit5() {

        DigitScrubber scrubber = new DigitScrubber();
        scrubber.scrub("   ");

    }

    //testing empty
    @Test(expected = IllegalArgumentException.class)
    public void ScrubberDigit6() {

        DigitScrubber scrubber = new DigitScrubber();
        scrubber.scrub("");

    }
}