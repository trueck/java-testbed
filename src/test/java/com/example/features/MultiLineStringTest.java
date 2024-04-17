package com.example.features;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MultiLineStringTest {

    @Test
    void multiline() {
        var shakespeare = """
                    To be, or not to be, that is the question:
                    Whether 'tis nobler in the mind to suffer
                    The slings and arrows of outrageous fortune,
                    Or to take arms against a sea of troubles
                    And by opposing end them. To die—to sleep,
                    No more; and by a sleep to say we end
                    The heart-ache and the thousand natural shocks
                    That flesh is heir to: 'tis a consummation
                    Devoutly to be wish'd. To die, to sleep;
                    To sleep, perchance to dream—ay, there's the rub:
                    For in that sleep of death what dreams may come,
                """;
        System.out.println("["+shakespeare+"]");
        Assertions.assertNotEquals(shakespeare.charAt(0), 'T');

        shakespeare = shakespeare.stripLeading();
        System.out.println("["+shakespeare+"]");
        assertEquals(shakespeare.charAt(0), 'T');
    }

    @Test
    void multiline2() {
        var text = """
                """;
        System.out.println("["+text+"]");
        assertEquals("", text);
    }

    @Test
    void multiline3() {
        var text = """
                string""";
        System.out.println("["+text+"]");
        assertEquals("string", text);
    }

    @Test
    void multiline4() {
        var text = """
                
                string""";
        System.out.println("["+text+"]");
        assertEquals("\nstring", text);
    }

    @Test
    void multiline5() {
        var text = """
                line1
                line2""";
        System.out.println("["+text+"]");
        assertEquals("line1\nline2", text);
    }

    @Test
    void multiline6() {
        var text = """
                line1
                  line2""";
        System.out.println("["+text+"]");
        assertEquals("line1\n  line2", text);
    }

    @Test
    void multiline7() {
        var text = """
                    line1
                  line2""";
        System.out.println("["+text+"]");
        assertEquals("  line1\nline2", text);
    }

    @Test
    void multiline8() {
        var text = """
                  line1
                  line2
                  """;
        System.out.println("["+text+"]");
        assertEquals("line1\nline2\n", text);
    }
}