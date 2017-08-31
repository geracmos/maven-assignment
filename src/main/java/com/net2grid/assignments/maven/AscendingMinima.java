package com.net2grid.assignments.maven;

import java.util.ArrayList;
import java.util.Vector;

/**
 * This class implements the Sliding Window Minima, using the Ascending Minima
 * Algorithm.
 */
public class AscendingMinima {

  private ArrayList<Integer> dataSet; // Input data set
  private ArrayList<Integer> result;  // Final result
  private int windowLength;           // Sliding window length
  private Vector<Integer> window;     // The current window
  private Vector<Integer> aMa;        // Ascending Minima Array - A vector is used instead
                                      // of an array for easier insertion/deletion
                                      // operations

  /**
   * This is the constructor of the AscendingMinima class. It initializes all necessary
   * variables and also creates the initial calculation window.
   *
   * @param dataSet An array list of integers, the sliding window will be applied to.
   * @param windowLength The length of the sliding window.
   */
  public AscendingMinima(ArrayList<Integer> dataSet, int windowLength){

    // Initialize the variables
    this.dataSet = dataSet;
    this.windowLength = windowLength;
    this.result = new ArrayList();
    this.aMa = new Vector();

    // Create the window
    window = new Vector<>(dataSet.subList(0, windowLength));
  }

  /**
   * This method retrieves the aMa vector.
   *
   * @return The aMa vector of integers.
   */
  public Vector<Integer> getAma() {
    return aMa;
  }

  /**
   * This method sets the aMa vector.
   *
   *  @param aMa A vector of integers.
   */
  public void setAma(Vector<Integer> aMa) {
    this.aMa = aMa;
  }

  /**
   * This method sets the current window.
   *
   * @param window A vector of integers.
   */
  public void setWindow(Vector<Integer> window) {
    this.window = window;
  }

  /**
   * This method calculates the sliding window minima, and returns the result.
   *
   * @return An array list of integers.
   */
  public ArrayList<Integer> calcMinima() {
    // Calculate the AMA for the first window
    ascendingMinima(0);

    // Store the 1st AMA element to the results array.
    result.add(aMa.firstElement());

    // Slide the window one element at a time and append the 1st element of AMA
    // to the result array.
    int slideIndex = windowLength;
    while(slideIndex < dataSet.size()){
      slideWindow(slideIndex);
      result.add(aMa.firstElement());
      slideIndex++;
    }

    //----------- DEBUG -----------//
    // Print result for debugging reasons
    System.out.println("[calcMinima] Final Result: " + result.toString());
    //---------- /DEBUG -----------//

    // Return the result
    return result;
  }

  /**
   * Calculates the Ascending Minima array (AMA) for the 1st window. In detail it
   * follows the steps below:
   *  1. Finds the smallest number in the window and stores its [value,index] in a vector
   *  2. Finds the smallest number in the subwindow starting from position index + 1
   *  3. Iterates until it reaches the end of the window
   *
   *  It also creates the initial window itself.
   *
   *@param startingIndex The index where the window or subwindow starts from
   */
  protected void ascendingMinima(int startingIndex){

    // End the recursive execution
    if(startingIndex == windowLength) return;

    // Variable declaration
    int elementIndex = startingIndex;     // Iteration pointer
    int currentMin = Integer.MAX_VALUE;   // The minimum value of the current window
    int currentMinIndex = 0;              // The dataSet index of the minimum value
    int element;                          // The current element of the dataSet array list

    // Iterate through the elements of the dataSet that are within the current window and
    // find the minimum value and its index.
    while(elementIndex < windowLength){
      element = dataSet.get(elementIndex);
      if(element <= currentMin) {
        currentMin = element;
        currentMinIndex = elementIndex;
      }
      elementIndex ++;
    }

    // Add the minimum value to the AMA.
    aMa.add(currentMin);

    //----------- DEBUG -----------//
    // Print the subwindow, minimum value, minimum index and aMa for each iteration
    System.out.println("[ascendingMinima] Window   : " + window.toString());
    System.out.println("[ascendingMinima] Subwindow: " + dataSet.subList(startingIndex, windowLength)
            .toString());
    System.out.println("[ascendingMinima] Min      : " + currentMin);
    System.out.println("[ascendingMinima] Min Index: " + currentMinIndex);
    System.out.println("[ascendingMinima] AMA      : " + aMa.toString());
    System.out.println("---------------------");
    //---------- /DEBUG -----------//

    // Find the minima for the subList starting from current_minimum + 1
    ascendingMinima(currentMinIndex + 1);
  }

  /**
   * Slides the window one element to the right and adjusts the AMA according to the
   * following steps:
   * 1. If the 1st element of the AMA is no longer in the new window, removes it from
   *    the AMA array
   * 2. Removes all items of AMA that are greater than the new item X
   * 3. Appends new item X at the end of AMA
   *
   * @param newElementIndex The index of the new element that appears from the sliding.
   */
  protected void slideWindow(int newElementIndex){

    // Variable declaration
    int newElement;   // The new element
    int aMaIndex;     // Iterator useful for accessing AMA backwards

    // Exit if the new element index is out of the dataSet bounds.
    if(newElementIndex >= dataSet.size())
      return;

    // Store the new element to a variable
    newElement = dataSet.get(newElementIndex);


    // Slide the window one item to the right
    window.removeElementAt(0);
    window.add(newElement);
    /* -- STEP 1 --
     * Remove the 1st element of AMA if it no longer exists in the window
     */
    if(! window.contains(aMa.get(0))) {
      aMa.removeElementAt(0);
    }

    // If the aMa is now empty, skip STEP 2.
    if(aMa.size() > 0) {
      /* -- STEP 2 --
       * Remove all elements from AMA that are larger than the new element
       * Start from the end of AMA to avoid making unnecessary iterations and
       * stop when the aMa items are smaller than the new element.
       */
      aMaIndex = aMa.size() - 1;
      while (aMaIndex >= 0) {
        if (aMa.get(aMaIndex) >= newElement) {
          aMa.removeElementAt(aMaIndex);
        }
        else
          break;
        aMaIndex--;
      }
    }
    /* -- STEP 3 --
     * Append the new element to AMA
     */
    aMa.add(newElement);


    //----------- DEBUG -----------//
    // Print AMA for debugging reasons
    System.out.println("[slideWindow] New element ["+ newElement + "] - AMA: " + aMa
            .toString
            ());
    //---------- /DEBUG -----------//
  }
}
