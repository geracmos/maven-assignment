package com.net2grid.assignments.maven;

import junit.framework.TestCase;

import java.util.ArrayList;

/**
 * This testcase tests how the ArrayStats class behaves using as input an Integer
 * array list.
 * It tests the case when the input array list has unsorted, even number of elements.
 */
public class EvenElementsArrayListTest extends TestCase {

  /**
  * Two variables are necessary for testing the ArrayStats:
  *   inputList: An Integer ArrayList, to feed the respective constructor.
  *   as: An ArrayStats instance.
  */
  private ArrayList<Integer> inputList;
  private ArrayStats as;

  /**
   * This method populates the input array and input list.
   * @throws Exception
   */
  public void setUp() throws Exception {
    // Test values are: {10, 0, 11, -10, 3, -2}
    inputList = new ArrayList<Integer>();
    inputList.add(10);
    inputList.add(0);
    inputList.add(11);
    inputList.add(-10);
    inputList.add(3);
    inputList.add(-2);
    as = new ArrayStats(inputList);
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