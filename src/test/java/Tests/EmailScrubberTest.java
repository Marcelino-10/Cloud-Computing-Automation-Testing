package Tests;

import org.example.Services.EmailScrubber;
import org.junit.Before;
import org.junit.Test;
import org.junit.Assert;

public class EmailScrubberTest {
    private EmailScrubber emailScrubber;
    private String hiddenEmail;

    @Before
    public void setUp() {
        emailScrubber = new EmailScrubber();
        hiddenEmail = "[EMAIL_HIDDEN]";
    }

    @Test
    public void TestValidEmail() {
        String input = "abanobessam@gmail.com";
        String result = emailScrubber.scrub(input);
        Assert.assertEquals(hiddenEmail, result);
    }

    @Test
    public void TestValidEmailInText() {
        String input = "Here is my email: abanobessam@stud.cu.edu.eg, lets chat!";
        String result = emailScrubber.scrub(input);
        Assert.assertEquals("Here is my email: " + hiddenEmail + ", lets chat!", result);
    }
    
    @Test
    public void TestValidEmailWithNumbers() {
        String input = "abanobessam19@gmail.com";
        String result = emailScrubber.scrub(input);
        Assert.assertEquals(hiddenEmail, result);
    }

    @Test
    public void TestInvalidEmailNoAt() {
        String input = "My email: abanobessamgmail.com";
        String result = emailScrubber.scrub(input);
        Assert.assertEquals(input, result);
    }

    @Test
    public void TestInvalidEmailNoDot() {
        String input = "My email: abanobessam@gmailcom";
        String result = emailScrubber.scrub(input);
        Assert.assertEquals(input, result);
    }

    @Test
    public void TestInvalidEmailTwoAt() {
        String input = "My email: abanob@@gmail.com";
        String result = emailScrubber.scrub(input);
        Assert.assertEquals(input, result);
    }

    @Test(expected = NullPointerException.class)
    public void TestNullEmail() {
        emailScrubber.scrub(null);
    }

    @Test(expected = NullPointerException.class)
    public void TestEmptyEmail() {
        emailScrubber.scrub("");
    }
}
