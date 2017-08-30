package com.net2grid.assignments.maven;

import junit.framework.TestCase;

/**
 * This testcase tests how the ArrayStats class behaves using as input an int array.
 * It tests the case when the input array has unsorted, even number of elements.
 */
public class EvenElementsArrayTest extends TestCase {

  /**
  * Two variables are necessary for testing the ArrayStats:
  *   inputArray: An int array, to feed the respective constructor.
  *   as: An ArrayStats instance.
  */
  private int[] inputArray;
  private ArrayStats as;

  /**
   * This method populates the input array and input list.
   * @throws Exception
   */
  public void setUp() throws Exception {
    inputArray = new int[]{10, 0, 11, -10, 3, -2};
    as = new ArrayStats(inputArray);
    super.setUp();
  }

  /**
   * This method verifies if the max() method provides the correct result.
   * @throws Exception
   */
  public void testMax() throws Exception {
    assertEquals(as.max(), 11);
  }

  /**
   * This method verifies if the min() method provides the correct result.
   * @throws Exception
   */
  public void testMin() throws Exception {
    assertEquals(as.min(), -10);
  }

  /**
   * This method verifies if the mean() method provides the correct result.
   * @throws Exception
   */
  public void testMean() throws Exception {
    assertEquals(as.mean(), 2.0);
  }

  /**
   * This method verifies if the median() method provides the correct result.
   * @throws Exception
   */
  public void testMedian() throws Exception {
    assertEquals(as.median(), 1.5);
  }
}