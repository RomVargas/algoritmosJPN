import java.util.*;

/**
 * The WaterfallStreams class in Java simulates the flow of water through a matrix, calculating the
 * final percentages of water flow at each position.
 */
public class WaterfallStreams {
    // The `waterfallStreams` method in the `WaterfallStreams` class takes a 2D array representing a
    // matrix and an integer `source` as parameters.
    public double[] waterfallStreams(double[][] array, int source) {
    double[] rowAbove = array[0];

   // The line `rowAbove[source] = -1;` in the `waterfallStreams` method is setting the value at the
   // specified `source` index in the `rowAbove` array to -1. This is done to indicate that the water
   // starts flowing from the `source` position in the matrix. By setting it to -1, it marks that this
   // position is the starting point for the water flow calculation in the subsequent rows of the
   // matrix.
    rowAbove[source] = -1;


    // This part of the `waterfallStreams` method in the `WaterfallStreams` class is responsible for
    // simulating the flow of water through the matrix. Here's a breakdown of what it does:
    for(int row = 1; row < array.length; row++) {
      double[] currentRow = array[row];
      for(int idx = 0; idx < rowAbove.length; idx++) {
        double valueAbove = rowAbove[idx];

        boolean hasWaterAbove = valueAbove < 0;
        boolean hasBlock = currentRow[idx] == 1.0;

        if (!hasWaterAbove) {
          continue;
        }
        if (!hasBlock) {
          currentRow[idx] += valueAbove;
          continue;
        }

        double splitWater = valueAbove / 2;
        int rightIdx = idx;
        while(rightIdx + 1 < rowAbove.length) {
          rightIdx += 1;
          if (rowAbove[rightIdx] == 1.0) {
            break;
          }
          if(currentRow[rightIdx] != 1) {
            currentRow[rightIdx] += splitWater;
            break;
          }
        }

        // This part of the `waterfallStreams` method in the `WaterfallStreams` class is responsible
        // for handling the flow of water to the left side of the current position in the matrix.
        // Here's a breakdown of what it does:
        int leftIdx = idx;
        while(leftIdx - 1 >= 0){
          leftIdx -= 1;
          if(rowAbove[leftIdx] == 1.0){
            break;
          }
          if(currentRow[leftIdx] != 1.0) {
            currentRow[leftIdx] += splitWater;
            break;
          }
        }
      }
      rowAbove = currentRow;
    }

    double[] finalPercentages = new double[rowAbove.length];
    for(int idx = 0; idx < rowAbove.length; idx++){
      double num = rowAbove[idx];
      if (num == 0 ){
        finalPercentages[idx] = num;
      } else {
        finalPercentages[idx] = (num * -100);
      }
    }
    return finalPercentages;
    
  
}
