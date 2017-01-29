/**
 * @author Olena Collins
 * Week 2 Santa Exercise
 */

package edu.madisoncollege.entjava;

import java.io.*;

import org.apache.log4j.*;

/**
 * Created by paulawaite on 9/7/16.
 * <p>
 * This exercise is taken from the 2015 Advent of Code challenge, Day 1 (http://adventofcode.com/day/1). It will provide you
 * with more practice in our environment, reading files, logging and unit testing.
 * <p>
 * Here is the problem to solve:
 * <p>
 * "Santa is trying to deliver presents in a large apartment building, but he can't find the right floor -
 * the directions he got are a little confusing. He starts on the ground floor (floor 0) and then follows
 * the instructions one character at a time.
 * <p>
 * An opening parenthesis, (, means he should go up one floor, and a closing parenthesis, ), means he should go down one floor.
 * <p>
 * The apartment building is very tall, and the basement is very deep; he will never find the top or bottom floors.
 * <p>
 * For example:
 * (()) and ()() both result in floor 0.  <= this would make a good unit test!
 * ((( and (()(()( both result in floor 3. <= another unit test
 * ))((((( also results in floor 3. <= another unit test
 * ()) and ))( both result in floor -1 (the first basement level).
 * ))) and )())()) both result in floor -3."
 * <p>
 * Your goal is to determine what floor Santa will be on when he uses the directions in the file SantaUpDown.txt
 * <p>
 * Do NOT create a main method in your application: you will use only unit tests to run your code.
 * Add log4j to your code.  At minimum you should log an error if there is a problem reading the file.
 * <p>
 * When submitting your code, include screenshots showing
 * 1) The answer, i.e., what floor is Santa on?
 * 2) How much code coverage you achieved (what percent?).
 */

public class SantaInAnElevator {
// your code to read in the file and determine the floor number goes here.
//Remember to structure your code in small, single-purpose methods
    private final Logger logger = Logger.getLogger(this.getClass());

    /**
     * Process file.
     */
    public void processFile() {
        String fileName = "/home/student/EnterpriseRepos/week-2-exercise-ocollins/src/test/resources/SantaUpDown.txt";
        readFile(fileName);
    }

    /**
     * Read file.
     *
     * @param fileName the file name
     */
    public void readFile(String fileName) {
        String lineIn = null;
        //ArrayList <String> myList = null;
        String [] tokenArray = null;

        try (BufferedReader bufferedReader =
                     new BufferedReader(new FileReader(fileName))) {
            while (bufferedReader.ready()) {
                lineIn = bufferedReader.readLine();

                tokenArray = lineIn.split("");
                logger.info("Santa is on the " + processLine(tokenArray) + " floor");
            }
        } catch (FileNotFoundException ex) {
            logger.error("Input file not found " + ex);
        } catch (IOException ioException) {
            logger.error("Problem reading the input file " + ioException);
        } catch (Exception exception) {
            logger.error("Error processing the input file " + exception);
        }

    }

    /**
     * Process line from the input file.
     * Calculate the floor
     *
     * @param lineIn the line in
     */
    public int processLine (String [] lineIn) {
        int leftBracket = 0;
        int rightBracket = 0;
        int floor = 0;

        for (int i = 0; i < lineIn.length; i ++) {
            if (lineIn [i].equals("(")) {
                leftBracket ++;
            }
            if (lineIn [i].equals(")")) {
                rightBracket ++;
            }
        }
        floor = leftBracket - rightBracket;
        return floor;

    }

}
