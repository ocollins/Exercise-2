package edu.madisoncollege.entjava;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * Practice working with JUnit by writing some test cases for the Interface List<E>:
 * 1.1 void add(int index, E e)
 * 1.2 void remove(int index)
 * 1.3 void get(int index)
 *
 * Add at least one test for an exception.
 */
public class ListTest {

    private List<String> myList;
    //Setting up for the tests
    @Before
    public void setup() {
        myList = new ArrayList<String>();
        myList.add("Item 1");
        myList.add("Item 2");
        myList.add("Item 3");
        myList.add("Item 4");
    }

    @Test
    public void testAddSuccess() {
        assertEquals("List size is incorrect", 4, myList.size());
        assertTrue("List missing element 4", myList.contains("Item 4"));
    }

    @Test
    public void testRemoveSuccess() {
        myList.remove(0);
        assertEquals("List size is incorrect", 3, myList.size());
        assertFalse("Item 1 is there", myList.contains("Item 1"));
    }

    @Test
    public void testItemThereSuccess() {
        assertEquals("Item 2", myList.get(1));
    }

    //Testing IndexOutOfBoundsException
    @Rule
    public ExpectedException thrown = ExpectedException.none();

    @Test
    public void testIndexOutOfBoundsException() throws IndexOutOfBoundsException {
        List<String> myList = new ArrayList<>();

        thrown.expect(IndexOutOfBoundsException.class);
        thrown.expectMessage("Index: 0, Size: 0");
        myList.get(0);
    }




}