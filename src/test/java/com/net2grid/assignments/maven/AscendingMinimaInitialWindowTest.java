package com.net2grid.assignments.maven;

import junit.framework.TestCase;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Vector;

/**
 * This testcase tests how the AscendingMinimaTest class behaves using as input an Integer
 * array list.
 */
public class AscendingMinimaInitialWindowTest extends TestCase {

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
            new Integer[]{5, 1, 3, 1, 3, 2, 6, 8, 4, 6}));
    am = new AscendingMinima(dataSet, 10);
    super.setUp();
  }

  /**
   * This method verifies if the ascendingMinima method calculates the AMA for the
   * initial window correctly.
   *
   * @throws Exception
   */
  public void testAscendingMinima() throws Exception {

    // Create a vector that contains the expected result
    Vector<Integer> expectedAMA = new Vector<Integer>(
            Arrays.asList(new Integer[]{1, 2, 4, 6}));

    // Calculate the AMA for the initial window
    am.ascendingMinima(0);

    // Test that the method has generated the expected AMA
    assertEquals(am.getAma(), expectedAMA);
  }

}