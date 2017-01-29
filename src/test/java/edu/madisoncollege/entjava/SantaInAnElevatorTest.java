package edu.madisoncollege.entjava;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by student on 1/24/17.
 *
 * @author O Collins
 */
public class SantaInAnElevatorTest {
    private SantaInAnElevator mySanta;

    /**
     * Sets .
     */
    @Before
    public void setup() {
        mySanta = new SantaInAnElevator();
    }

    /**
     * Test santa with file.
     *
     * @throws Exception the exception
     */
    @Test
    public void testSantaWithFile() throws Exception {
        mySanta.processFile();
    }

    /**
     * Test floor equals zero with string 1.
     */
    @Test
    public void testFloorEqualsZeroWithString1() {
        String[] testArray = {"(", "(", ")", ")"};
        assertEquals("Santa should be on the 0th floor ", 0, mySanta.processLine(testArray));

    }

    /**
     * Test floor equals zero with string 2.
     */
    @Test
    public void testFloorEqualsZeroWithString2() {
        String[] testArray = {"(", ")", "(", ")"};
        assertEquals("Santa should be on the 0th floor ", 0, mySanta.processLine(testArray));

    }

    /**
     * Test floor equals two with string 1.
     */
    @Test
    public void testFloorEqualsOneWithString1() {
        String[] testArray = {"(", "(", "(", ")", ")"};
        assertEquals("Santa should be on the 1st floor ", 1, mySanta.processLine(testArray));

    }


    /**
     * Test floor equals three with string 1.
     */
    @Test
    public void testFloorEqualsThreeWithString1() {
        String[] testArray = {"(", "(", "("};
        assertEquals("Santa should be on the 3rd floor ", 3, mySanta.processLine(testArray));

    }

}