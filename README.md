# maven-assignment
This is a small java project using Maven, created mostly for training purposes.

## 1. ArrayStats
The class ArrayStats, is able to provide the mean, median, max and min value over
an array of integer values. Also, this class can provide the same statistical measurements
for an array list of Integer values.

### 1.1 Assumptions:

* If the input array or arraylist are empty, no error will be thrown, but:
* Methods max() and min() will return 0
* Methods mean() and median() will return Double.NaN

## 2. AscendingMinima
The class AscendingMinima implements the Ascending Minima Algorithm (aka sliding window minimum), using the following logic:

1. Calculates the Ascending Minima array (AMA) for the 1st window
    * Finds the smallest number in the window and stores its value in a vector
    * Finds the smallest number in the subwindow starting from position index + 1
    * Iterates until it reaches the end of the window
1. Stores the 1st element of the AMA to the output array.
1. Slides the window one element at a time (removes the 1st element, and appends the new one at the end)
    * If the 1st element of the AMA is no longer in the new window, removes it from the AMA array
    * Removes all items of AMA that are greater than the new item X
    * Appends new item X at the end of AMA
    * Appends the 1st element of AMA to the output array.
