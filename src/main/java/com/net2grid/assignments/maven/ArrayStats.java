package com.net2grid.assignments.maven;

import com.google.common.primitives.Doubles;
import com.google.common.primitives.Ints;
import org.apache.commons.math3.stat.descriptive.moment.Mean;
import org.apache.commons.math3.stat.descriptive.rank.Median;
import java.util.ArrayList;

/**
 * This class contains public methods that return the min, max, mean and median of
 * an array of integers.
 */
public class ArrayStats{


  protected int[] intArray;           // The input array of integers.
  protected double[] doubleArray;     // Auxiliary array of doubles, necessary for
                                      // calculating mean and median.

  /**
   * This is the constructor method of the class.
   *
   * @param intArray An array of integers.
   */
  public ArrayStats(int[] intArray) {
    this.intArray = intArray;
    this.doubleArray = Doubles.toArray(Ints.asList(intArray));
  }

  /**
   * This constructor method of the class can handle ArrayList objects.
   *
   * @param intArrayList An array list of integers.
   */
  public ArrayStats(ArrayList<Integer> intArrayList) {
    this.intArray = Ints.toArray(intArrayList);
    this.doubleArray = Doubles.toArray(Ints.asList(intArray));
  }

  /**
   * This method calculates and returns the maximum value of the array.
   * If the intArray has not been initialized, it returns 0.
   *
   * @return The maximum value of the array or 0 if the array is empty.
   */
  public int max(){
    if (intArray.length > 0) {
      return Ints.max(intArray);
    }
    else
      return 0;
  }

  /**
   * This method calculates and returns the minimum value of the array.
   * If the intArray has not been initialized, it returns 0.
   *
   * @return The minimum value of the array or 0 if the array is empty.
   */
  public int min(){
    if (intArray.length > 0) {
      return Ints.min(intArray);
    }
    else
      return 0;
  }

  /**
   * This method calculates and returns the mean value of the array.
   * If the intArray has not been initialized, it returns NaN.
   *
   * @return The mean value of the array or NaN if the array is empty.
   */
  public double mean(){
    if (intArray.length > 0) {
      return new Mean().evaluate(doubleArray);
    }
    else
      return Double.NaN;
  }

  /**
   * This method calculates and returns the median value of the array.
   * If the intArray has not been initialized, it returns NaN.
   *
   * @return The mean value of the array or NaN if the array is empThis is the constructor method of the class.ty.
   */
  public double median(){
    if (intArray.length > 0) {
      return new Median().evaluate(doubleArray);
    }
    else
      return Double.NaN;
  }
}
