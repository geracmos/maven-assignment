package com.net2grid.assignments.maven;

import junit.framework.TestCase;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Vector;

/**
 * This testcase tests how the AscendingMinimaTest class behaves using as input an Integer
 * array list.
 */
public class AscendingMinimaTest extends TestCase {

  /**
   * The following variables are necessary:
   * dataSet: An Integer ArrayList, with the data where the sliding window algorithm will
   *          be applied.
   * windowLength: The sliding window length
   * am: An AscendingMinima instance
   */
  private ArrayList<Integer> dataSet;
  private int windowLength;
  private AscendingMinima am;

  /**
   * This method populates the input array and input list.
   *
   * @throws Exception
   */
  public void setUp() throws Exception {
    // Initialize variables
    dataSet = new ArrayList<Integer>(Arrays.asList(
            new Integer[]{5, 1, 3, 1, 3, 2, 6, 8, 4, 6, 1}));
    windowLength = 3;
    am = new AscendingMinima(dataSet, windowLength);
    super.setUp();
  }

  /**
   * This method verifies if the slideWindow method calculates the AMA correctly for
   * several slide iterations.
   *
   * @throws Exception
   */
  public void testSlideWindow() throws Exception {

    // Variable declaration
    Vector<Integer> initialAMA;     // A vector that contains the initial AMA
    Vector<Integer> expectedAMA;    // A vector that contains the expected AMA
    Vector<Integer> window;         // The current window

    /* --------- TEST 1 ---------
     DataSet        : [5, 1, 3, 1, 3, 2, 6, 8, 4, 6, 1]
     Current window : [5, 1, 3]
     Initial AMA    : [1, 3]
     Expected AMA   : [1]

     The element {3} is expected to be removed from the AMA since the new item has
     a lower value.
     */

    // Variable initialization
    window      = new Vector<Integer>(Arrays.asList(new Integer[]{5, 1, 3}));
    initialAMA  = new Vector<Integer>(Arrays.asList(new Integer[]{1, 3}));
    expectedAMA = new Vector<Integer>(Arrays.asList(new Integer[]{1}));

    // Setup and calculate AMA
    am.setAma(initialAMA);
    am.setWindow(window);
    am.slideWindow(windowLength);

    // Verify that the method returns the expected result
    assertEquals(expectedAMA, am.getAma());

    /* --------- TEST 2 ---------
     DataSet        : [5, 1, 3, 1, 3, 2, 6, 8, 4, 6, 1]
     Current window : [3, 1, 3]
     Initial AMA    : [1, 3]
     Expected AMA   : [1, 2]

     The new element {2} is lower than {3} so the latter will be removed from AMA and the
     new element will take its place.
     */

    // Variable initialization
    window      = new Vector<Integer>(Arrays.asList(new Integer[]{3, 1, 3}));
    initialAMA  = new Vector<Integer>(Arrays.asList(new Integer[]{1, 3}));
    expectedAMA = new Vector<Integer>(Arrays.asList(new Integer[]{1, 2}));

    // Setup and calculate AMA
    am.setAma(initialAMA);
    am.setWindow(window);
    am.slideWindow(windowLength + 2);

    // Verify that the method returns the expected result
    assertEquals(expectedAMA, am.getAma());

    /* --------- TEST 3 ---------
     DataSet        : [5, 1, 3, 1, 3, 2, 6, 8, 4, 6, 1]
     Current window : [1, 3, 2]
     Initial AMA    : [1, 2]
     Expected AMA   : [2, 6]

     1. The element {1} will be removed from AMA since it no longer exists in the
        window
     2. The element {6} will be added to the AMA in the last position
        The AMA will turn to [2, 6]
     */

    // Variable initialization
    window      = new Vector<Integer>(Arrays.asList(new Integer[]{1, 3, 2}));
    initialAMA  = new Vector<Integer>(Arrays.asList(new Integer[]{1, 2}));
    expectedAMA = new Vector<Integer>(Arrays.asList(new Integer[]{2, 6}));

    // Setup and calculate AMA
    am.setAma(initialAMA);
    am.setWindow(window);
    am.slideWindow(windowLength + 3);

    // Verify that the method returns the expected result
    assertEquals(expectedAMA, am.getAma());


    /* --------- TEST 4 ---------
     DataSet        : [5, 1, 3, 1, 3, 2, 6, 8, 4, 6, 1]
     Current window : [8, 4, 6]
     Initial AMA    : [4, 6]
     Expected AMA   : [1]

     The element {4} and {6} will be removed from AMA since they are smaller than
     the new element {1}
     */

    // Variable initialization
    window      = new Vector<Integer>(Arrays.asList(new Integer[]{8, 4, 6}));
    initialAMA  = new Vector<Integer>(Arrays.asList(new Integer[]{4, 6}));
    expectedAMA = new Vector<Integer>(Arrays.asList(new Integer[]{1}));

    // Setup and calculate AMA
    am.setAma(initialAMA);
    am.setWindow(window);
    am.slideWindow(windowLength + 7);

    // Verify that the method returns the expected result
    assertEquals(expectedAMA, am.getAma());

    /* --------- TEST 5 ---------
     DataSet        : [5, 1, 3, 1, 3, 2, 6, 8, 4, 6, 1]
     Current window : [4, 6, 1]
     Initial AMA    : [1]
     Expected AMA   : [1]

     The window will get out of bounds, so the function will not affect anything. Both
     the AMA and the window will remain the same.
     */

    // Variable initialization
    window      = new Vector<Integer>(Arrays.asList(new Integer[]{4, 6, 1}));
    initialAMA  = new Vector<Integer>(Arrays.asList(new Integer[]{1}));
    expectedAMA = new Vector<Integer>(Arrays.asList(new Integer[]{1}));

    // Setup and calculate AMA
    am.setAma(initialAMA);
    am.setWindow(window);
    am.slideWindow(windowLength + 8);

    // Verify that the method returns the expected result
    assertEquals(expectedAMA, am.getAma());
  }


  /**
   * This method verifies if the calcMinima method calculates the AMA for the
   * initial window correctly.
   *
   * @throws Exception
   */
  public void testCalcMinima() throws Exception {

    // Variable declaration
    ArrayList<Integer> expectedResult; // An array list that contains the expected result

    // Variable initialization
    expectedResult = new ArrayList<>(Arrays.asList(
            new Integer[]{1, 1, 1, 1, 2, 2, 4, 4, 1}));

    // Test that the method has generated the expected result
    assertEquals(expectedResult, am.calcMinima());
  }
}