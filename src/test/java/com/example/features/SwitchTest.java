package com.example.features;


import org.junit.jupiter.api.Test;

import java.time.DayOfWeek;

import static java.util.Calendar.MONDAY;
import static java.util.Calendar.TUESDAY;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class SwitchTest {

    @Test
    void testSwitchStatementColon(){
        int result = 0;
        switch(MONDAY){
            case MONDAY: result = 1; break;
            case TUESDAY: result = 2;break;
            default : result = 99;
        }
        assertEquals(1, result);
    }

    @Test
    void testSwitchStatementArrow(){
        int result = 0;
        switch(MONDAY){
            case MONDAY -> result = 1;
            case TUESDAY -> result = 2;
            default -> result = 99;
        }
        assertEquals(1, result);
    }

    @Test
    void testSwitchExpressionArrow(){
        int result = switch(MONDAY){
            case MONDAY ->{
                System.out.println("hit Monday.");
                yield 1;
            }
            case TUESDAY -> 2;
            default -> 99;
        };
        assertEquals(1, result);
    }

    @Test
    void testSwitchExpressionColon(){
        int result = switch(MONDAY){
            case MONDAY: {
                System.out.println("hit Monday.");
                yield 1;
            }
            case TUESDAY : yield 2;
            default : yield 99;
        };
        assertEquals(1, result);
    }

    int calculateTimeOffClassic(DayOfWeek dayOfWeek) {
        var timeoff = 0;
        switch (dayOfWeek) {
            case MONDAY, TUESDAY, WEDNESDAY, THURSDAY, FRIDAY:
                timeoff = 16;
                break;
            case SATURDAY, SUNDAY:
                timeoff = 24;
                break;
        }
        return timeoff;
    }

    int calculateTimeOff(DayOfWeek dayOfWeek) {
        return switch (dayOfWeek) {
            case MONDAY, TUESDAY, WEDNESDAY, THURSDAY, FRIDAY -> 16;
            case SATURDAY, SUNDAY -> 24;
        };
    }

    @Test
    void testCalculateTimeOff() {
        assertEquals(calculateTimeOffClassic(DayOfWeek.SATURDAY), calculateTimeOff (DayOfWeek.SATURDAY));
        assertEquals(calculateTimeOff(DayOfWeek.FRIDAY), 16);
        assertEquals(calculateTimeOff(DayOfWeek.FRIDAY), 16);
    }
}