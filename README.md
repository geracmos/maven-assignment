# maven-assignment
This is a small java project using Maven, created mostly for training purposes.

This assignment includes two parts:

1. The class ArrayStats, which is able to provide the mean, median, max and min value over
an array of integer values. Also, this class can provide the same statistical measurements
for an array list of Integer values.

1.1 Assumptions:

    If the input array or arraylist are empty, no error will be thrown, but:
        -   Methods max() and min() will return 0
        -   Methods mean() and median() will return Double.NaN

2. A class that implements the Ascending Minima Algorithm, using the following logic:

    A. Calculates the Ascending Minima array (AMA) for the 1st window
        A.1 Finds the smallest number in the window and stores its [value,index] in a
            vector
        A.2 Finds the smallest number in the subwindow starting from position index + 1
        A.3 Iterates until it reaches the end of the window
    B. Stores the 1st element of the AMA to the output array.
    C. Slides the window one element at a time (removes the 1st element, and appends the
        new one at the end)
        C.1 If the 1st element of the AMA is no longer in the new window, removes it from
            the AMA array
        C.2 Removes all items of AMA that are greater than the new item X
        C.3 Appends new item X at the end of AMA
        C.4 Appends the 1st element of AMA to the output array.
