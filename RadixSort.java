/*
23.12 Write a program that randomly generates 1,000,000 integers and sorts them using radix sort.
*/

package radixsort;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class RadixSort {


    public static void main(String[] args) {
           
        //Generate 1 mill integers
   int max = 1000000;
  int[] list = new int[10]; 
  for (int i = 0; i < list.length; i++) {
   list[i] = (int) (Math.random() * max);
  }
  
  radixSort(list);
  System.out.println(Arrays.toString(list));
 }

    private static void radixSort(int[] list) {
       
         final int RAD = 10;
    
    // declare and initialize
    List<Integer>[] bucket = new ArrayList[RAD];
    
    for (int i = 0; i < bucket.length; i++) {
      bucket[i] = new ArrayList<Integer>();
    }

    // sort
    boolean maxLength = false;
    int tmp = -1, placement = 1;
    while (!maxLength) {
      maxLength = true;
      
     
      for (Integer i : list) {
        tmp = i / placement;
        bucket[tmp % RAD].add(i);
        if (maxLength && tmp > 0) {
          maxLength = false;
        }
      }
      
      int a = 0;
      for (int b = 0; b < RAD; b++) {
        for (Integer i : bucket[b]) {
          list[a++] = i;
        }
        bucket[b].clear();
      }
      
      // move to next digit
      placement *= RAD;
    }
  }
}
 